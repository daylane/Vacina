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

import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping("vacinas/registrar-vacina")
    public ResponseEntity<Vacina> registrarVacina(@RequestBody Vacina vacina){
<<<<<<< HEAD
        try{
            vacinaService.registrarVacina(vacina);
            return ResponseEntity.status(HttpStatus.CREATED).body(vacina);
=======
<<<<<<< Updated upstream
        vacinaService.registrarVacina(vacina);
        return ResponseEntity.status(HttpStatus.CREATED).build();
=======
        try{
            vacinaService.registrarVacina(vacina);
            return ResponseEntity.status(HttpStatus.CREATED).build();
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
        }
        catch (Exception ex){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Vacina não registrada", ex);
        }
<<<<<<< HEAD

=======
>>>>>>> Stashed changes
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
    }

    @PostMapping("vacinas/mockVacinasFake")
    public ResponseEntity<Void> mockVacinasFake(){
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
        vacinaService.mockVacinasFake();
        return ResponseEntity.created(null).build();
=======
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
       try {
           vacinaService.mockVacinasFake();
           return ResponseEntity.created(null).build();
       }
       catch (Exception ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não resgistrada", ex);
       }
<<<<<<< HEAD

=======
>>>>>>> Stashed changes
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
    }

    @GetMapping("/vacinas")
    public ResponseEntity<List<Vacina>> obterVacinas() {
<<<<<<< HEAD
       try {
           List<Vacina> vacinaLista = vacinaService.obterVacinas();
           return ResponseEntity.status(HttpStatus.ACCEPTED).body(vacinaLista);
=======
<<<<<<< Updated upstream
        List<Vacina> vacina = vacinaService.obterVacinas();
        return ResponseEntity.ok().body(vacina);
=======
       try {
           List<Vacina> vacina = vacinaService.obterVacinas();
           return ResponseEntity.ok().body(vacina);
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
       }
       catch (Exception ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar vacinas", ex);
       }
<<<<<<< HEAD

=======
>>>>>>> Stashed changes
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> obterVacinaPeloId(@PathVariable String id){
<<<<<<< HEAD
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(vacinaService.obterVacinasPeloId(id));
=======
<<<<<<< Updated upstream
        return ResponseEntity.ok().body(vacinaService.obterVacinasPeloId(id));
=======
        try {
            return ResponseEntity.ok().body(vacinaService.obterVacinasPeloId(id));
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a vacina.", ex);
        }
<<<<<<< HEAD

=======
>>>>>>> Stashed changes
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
    }

    @PutMapping("vacinas/{id}")
    public  ResponseEntity<Vacina> update(@RequestBody Vacina novaVacina, @PathVariable String id){
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
        return ResponseEntity.ok().body(vacinaService.update(novaVacina, id));
=======
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
        try {
            return ResponseEntity.ok().body(vacinaService.update(novaVacina, id));
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel atualizar a vacina.", ex);
        }
<<<<<<< HEAD

=======
>>>>>>> Stashed changes
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46
    }

    @DeleteMapping("vacinas/deletar-vacina/{id}")
    public ResponseEntity<Void> deletarVacina(@PathVariable String id ) {
<<<<<<< HEAD
       try{
           vacinaService.deletarVacina(id);
           return ResponseEntity.noContent().build();
       }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel excluir a vacina.", ex);
        }
=======
<<<<<<< Updated upstream
        vacinaService.deletarVacina(id);
        return ResponseEntity.noContent().build();
>>>>>>> 871eff50b9d36543be2fd3af1330ecc2a896bc46

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
