package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;



import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/testes-junit5", produces = {"application/json"})
public class VacinaController {

    @Autowired
    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {this.vacinaService = vacinaService;}

    @PostMapping("/vacinas/registrar-vacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody @Valid Vacina vacina) {
        try {
            Vacina vacinaSalva = vacinaService.registrarVacina(vacina);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaSalva);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não registrada", ex);
        }
    }



    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> listarVacinas() {

        try {
            List<Vacina> vacinaLista = vacinaService.listarVacinas();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Collections.singletonList((Vacina) vacinaLista));

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar vacinas cadastradas", ex);
        }

    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> buscarVacinaPorId(@PathVariable String id) {

        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaService.buscarVacina(id));

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a vacina.", ex);
        }
    }

    @PutMapping("/vacinas/atualizar/{id}")
    public ResponseEntity<Vacina> atualizarVacina(@RequestBody @Valid Vacina vacinaAtualizada, @PathVariable String id) {
        if (vacinaAtualizada == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A vacina não pode ser nula");
        }
        try {
            Optional<Vacina> optionalVacina = vacinaService.buscarVacina(id);
            if (optionalVacina.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada.");
            }
            Vacina vacinaExistente = optionalVacina.get();

            BeanUtils.copyProperties(vacinaAtualizada,vacinaExistente);
  /*          vacinaExistente.setFabricante(vacinaAtualizada.getFabricante());
            vacinaExistente.setLote(vacinaAtualizada.getLote());
            vacinaExistente.setDataValidade(vacinaAtualizada.getDataValidade());
            vacinaExistente.setNumeroDoses(vacinaAtualizada.getNumeroDoses());
            vacinaExistente.setIntervaloMinimoEntreDoses(vacinaAtualizada.getIntervaloMinimoEntreDoses());*/

            Vacina vacinaSalva = vacinaService.registrarVacina(vacinaExistente);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaSalva);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível atualizar a vacina.", ex);
        }
    }

    //metodo para atualizar parcialmente (Obs: vou avaliar real necessidade desse metodo);
    @PatchMapping("/vacinas/atualizar-parcialmente/{id}")
    public ResponseEntity<Vacina> atualizarVacinaParcialmente(@RequestParam("vacina") @RequestBody @Valid Vacina vacinaAtualizada, @PathVariable String id) {
        if (vacinaAtualizada == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A vacina não pode ser nula");
        }
        try {
            Optional<Vacina> optionalVacina = vacinaService.buscarVacina(id);
            if (optionalVacina.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada.");
            }
            Vacina vacinaExistente = optionalVacina.get();
            Optional<Vacina> vacina = vacinaService.buscarVacina(vacinaAtualizada.getId());
            Vacina vacinaSalva = vacinaService.registrarVacina(vacinaExistente);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaSalva);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível atualizar a vacina.", ex);
        }
    }

    @DeleteMapping("vacinas/deletar-vacina/{id}")
    public ResponseEntity<String> deletarVacina(@PathVariable String id) {

        try {
            vacinaService.deletarVacina(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Vacina excluída com sucesso!");

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel excluir a vacina.", ex);
        }
    }

}


