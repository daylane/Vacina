package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping("vacinas/registrar-vacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody Vacina vacina){
        vacinaService.registrarVacina(vacina);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> obterVacinas() {
        List<Vacina> vacina = vacinaService.obterVacinas();
        return ResponseEntity.ok().body(vacina);
    }


    @DeleteMapping("vacinas/deletar-vacina")
    public ResponseEntity<Void> deletarVacina(@PathVariable String id ) {
        vacinaService.deletarVacina(id);
        return ResponseEntity.noContent().build();

    }
}
