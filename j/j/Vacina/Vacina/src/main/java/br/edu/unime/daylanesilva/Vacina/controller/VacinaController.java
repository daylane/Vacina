package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping("vacinas/registrar-vacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody Vacina vacina) {

        try {
            vacinaService.registrarVacina(vacina);
            return ResponseEntity.status(HttpStatus.CREATED).body(vacina);

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não registrada", ex);
        }


    }




    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> obterVacinas() {

        try {
            List<Vacina> vacinaLista = vacinaService.obterVacinas();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(Collections.singletonList((Vacina) vacinaLista));

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar vacinas", ex);
        }

    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> obterVacinaPeloId(@PathVariable String id) {

        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(vacinaService.obterVacinasPeloId(id));

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a vacina.", ex);
        }
    }

    @PutMapping("vacinas/{id}")
    public ResponseEntity<Vacina> update(@RequestBody Vacina novaVacina, @PathVariable String id) {
        try {
            return ResponseEntity.ok().body(vacinaService.update(novaVacina, id));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel atualizar a vacina.", ex);
        }


    }

    @DeleteMapping("vacinas/deletar-vacina/{id}")
    public ResponseEntity<Void> deletarVacina(@PathVariable String id) {

        try {
            vacinaService.deletarVacina(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel excluir a vacina.", ex);
        }
    }

}


