package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< Updated upstream
=======
import org.springframework.web.server.ResponseStatusException;
>>>>>>> Stashed changes

import java.util.List;
import java.util.Optional;

@RestController
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping("vacinas/registrar-vacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody Vacina vacina){
<<<<<<< Updated upstream
        vacinaService.registrarVacina(vacina);
        return ResponseEntity.status(HttpStatus.CREATED).build();
=======
        try{
            vacinaService.registrarVacina(vacina);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception ex){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Vacina não registrada", ex);
        }
>>>>>>> Stashed changes
    }

    @PostMapping("vacinas/mockVacinasFake")
    public ResponseEntity<Void> mockVacinasFake(){
<<<<<<< Updated upstream
        vacinaService.mockVacinasFake();
        return ResponseEntity.created(null).build();
=======
       try {
           vacinaService.mockVacinasFake();
           return ResponseEntity.created(null).build();
       }
       catch (Exception ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não resgistrada", ex);
       }
>>>>>>> Stashed changes
    }

    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> obterVacinas() {
<<<<<<< Updated upstream
        List<Vacina> vacina = vacinaService.obterVacinas();
        return ResponseEntity.ok().body(vacina);
=======
       try {
           List<Vacina> vacina = vacinaService.obterVacinas();
           return ResponseEntity.ok().body(vacina);
       }
       catch (Exception ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar vacinas", ex);
       }
>>>>>>> Stashed changes
    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> obterVacinaPeloId(@PathVariable String id){
<<<<<<< Updated upstream
        return ResponseEntity.ok().body(vacinaService.obterVacinasPeloId(id));
=======
        try {
            return ResponseEntity.ok().body(vacinaService.obterVacinasPeloId(id));
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a vacina.", ex);
        }
>>>>>>> Stashed changes
    }

    @PutMapping("vacinas/{id}")
    public  ResponseEntity<Vacina> update(@RequestBody Vacina novaVacina, @PathVariable String id){
<<<<<<< Updated upstream
        return ResponseEntity.ok().body(vacinaService.update(novaVacina, id));
=======
        try {
            return ResponseEntity.ok().body(vacinaService.update(novaVacina, id));
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel atualizar a vacina.", ex);
        }
>>>>>>> Stashed changes
    }

    @DeleteMapping("vacinas/deletar-vacina/{id}")
    public ResponseEntity<Void> deletarVacina(@PathVariable String id ) {
<<<<<<< Updated upstream
        vacinaService.deletarVacina(id);
        return ResponseEntity.noContent().build();

=======
       try{
           vacinaService.deletarVacina(id);
           return ResponseEntity.noContent().build();
       }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel excluir a vacina.", ex);
        }
>>>>>>> Stashed changes
    }
}
