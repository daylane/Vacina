package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.BusinessException;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/vacina")
public class VacinaController {

    @Autowired
    private  VacinaService vacinaService;


    @PostMapping("/vacinas/registrarvacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody @Valid Vacina vacina) throws BusinessException {
        try {
            Vacina vacinaSalva = vacinaService.registrarVacina(vacina);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaSalva);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não registrada", exception);
        }
    }



    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> listarVacinas() throws BusinessException {

        try {
            List<Vacina> vacinaLista = vacinaService.listarVacinas();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Collections.singletonList((Vacina) vacinaLista));

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar vacinas cadastradas", exception);
        }

    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> buscarVacinaPorId(@PathVariable String id) {

        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaService.buscarVacina(id));

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a vacina.", exception);
        }
    }

    @PutMapping("/vacinas/atualizar/{id}")
    public ResponseEntity<Vacina> atualizarVacina(@RequestBody @Valid Vacina vacinaAtualizada, @PathVariable String id){
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
            Vacina vacinaSalva = vacinaService.registrarVacina(vacinaExistente);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(vacinaSalva);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível atualizar a vacina.", exception);
        }
    }

    @DeleteMapping("vacinas/deletarvacina/{id}")
    public ResponseEntity<String> deletarVacina(@PathVariable String id) {

        try {
            vacinaService.deletarVacina(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Vacina excluída com sucesso!");

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel excluir a vacina.", exception);
        }
    }

}


