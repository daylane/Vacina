package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping("vacinas/registrar-vacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody Vacina vacina){
        vacinaService.registrarVacina(vacina);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("vacinas/mockVacinasFake")
    public ResponseEntity<Void> mockVacinasFake(){
        vacinaService.mockVacinasFake();
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> obterVacinas() {
        List<Vacina> vacina = vacinaService.obterVacinas();
        return ResponseEntity.ok().body(vacina);
    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> obterVacinaPeloId(@PathVariable String id){
        return ResponseEntity.ok().body(vacinaService.obterVacinasPeloId(id));
    }

    @PutMapping("vacinas/{id}")
    public  ResponseEntity<Vacina> update(@RequestBody Vacina novaVacina, @PathVariable String id){
        return ResponseEntity.ok().body(vacinaService.update(novaVacina, id));
    }

    @DeleteMapping("vacinas/deletar-vacina/{id}")
    public ResponseEntity<Void> deletarVacina(@PathVariable String id ) {
        vacinaService.deletarVacina(id);
        return ResponseEntity.noContent().build();

    }
}
