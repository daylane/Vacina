package br.edu.unime.daylanesilva.Vacina.controller;

import br.edu.unime.daylanesilva.Vacina.dto.VacinaDTO;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.BusinessException;
<<<<<<< HEAD
import br.edu.unime.daylanesilva.Vacina.exception.VacinaNotFoundException;
import br.edu.unime.daylanesilva.Vacina.serviceTest.VacinaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
import br.edu.unime.daylanesilva.Vacina.serviceTest.VacinaService;
import org.springframework.beans.BeanUtils;
>>>>>>> origin/develop
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/vacina")
public class VacinaController {

    private static final Logger logger = LoggerFactory.getLogger(VacinaController.class);
    @Autowired
    private  VacinaService vacinaService;

    @GetMapping("/vacinas")
    public List<Vacina> listarVacinas(){
        try {
<<<<<<< HEAD
            logger.info("Recebida uma solicitação para inserir uma nova vacina");
            return VacinaService.listarVacinas();
        }
        catch (Exception ex){
            logger.error("Erro ao tentar todas as vacinas", ex);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar todas as vacinas", ex);
=======
            List<Vacina> vacinaLista = VacinaService.listarVacinas();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Collections.singletonList((Vacina) vacinaLista));

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel listar vacinas cadastradas", exception);
>>>>>>> origin/develop
        }
    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> findById(@Valid @PathVariable String id) {
        try {
            logger.info("Buscando paciente pelo ID: {}", id );
            return ResponseEntity.ok().body(vacinaService.findByid(id));
        } catch (Exception ex){
            logger.error("Erro ao buscar a vacina pelo ID: {}", id, ex);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel achar essa vacina", ex);
        }
    }

    @PostMapping("/vacinas/registrarvacina")
<<<<<<< HEAD
    public ResponseEntity<Vacina> registrarVacina(@RequestBody @Valid VacinaDTO vacinaDTO) throws BusinessException {
=======
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




    @PutMapping("/vacinas/atualizar/{id}")
    public ResponseEntity<Vacina> atualizarVacina(@RequestBody @Valid Vacina vacinaAtualizada, @PathVariable String id){
        if (vacinaAtualizada == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A vacina não pode ser nula");
        }
>>>>>>> origin/develop
        try {
            logger.info("Recebendo solicitação para inserir um nova vacina.");
            Vacina vacina = new Vacina(vacinaDTO);
            vacinaService.registrarVacina(vacina);

            logger.info("Nova vacina registrada com sucesso.");

            return ResponseEntity.created(null).body(vacina);
        }
        catch (Exception ex) {
            logger.error("Erro ao processar a solicitação de inserção de vacina.", ex);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não resgistrada", ex);
        }
    }




    @PutMapping("/vacinas/atualizar/{id}")
    public ResponseEntity<Vacina> atualizarVacina(@RequestBody @Valid VacinaDTO vacinaDTO, @PathVariable String id){
        try {
            logger.info("Recebendo solicitação para atualizar vacina com ID: {}", id);

            return ResponseEntity.ok().body(vacinaService.atualizarVacina(vacinaDTO, id));
        }
        catch (VacinaNotFoundException ex) {
            logger.error("Erro ao processar a solicitação de atualização da vacina.", ex);
            throw ex;
        } catch (Exception ex) {
            logger.error("Erro ao processar a solicitação de atualização da vacina.", ex);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar a vacina", ex);
        }
    }

    @DeleteMapping("vacinas/deletarvacina/{id}")
    public ResponseEntity<String> deletarVacina(@PathVariable String id) {

        try{
            logger.info("Recebendo solicitação para excluir paciente com ID: {}", id);

            vacinaService.deletarVacina(id);

            logger.info("Paciente excluído com sucesso.");

            return ResponseEntity.noContent().build();
        } catch (VacinaNotFoundException ex) {
            logger.error("Paciente não encontrado com o ID: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar a vacina.", ex);
        } catch (Exception ex) {
            logger.error("Erro ao processar a solicitação de exclusão do paciente.", ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao excluir a vacina", ex);
        }
    }

}


