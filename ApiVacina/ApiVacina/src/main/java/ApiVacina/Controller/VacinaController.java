package ApiVacina.Controller;

import ApiVacina.entity.Vacina;
import ApiVacina.service.VacinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("api/vacinas")
public class VacinaController {
    private Logger logger = LoggerFactory.getLogger(VacinaController.class);

    @Autowired
    private VacinaService vacinaService;

    @GetMapping("api/vacinas")
    public List<Vacina> listarVacinas(@RequestParam(required = false) String fabricante, String vacina) {

        try {
            logger.info("Recebida uma solicitação para listar vacinas");
            return vacinaService.listarVacinas(fabricante, vacina);

        } catch (Exception ex) {
            logger.info("Erro ao tentar todas as vacinas" + ex);
            throw new ResponseStatusException(HttpStatus.ACCEPTED, "Erro ao listar a vacinas", ex);
        }
    }

    @GetMapping("/vacinas/{id}")
    public ResponseEntity<Optional<Vacina>> findById(@Valid @PathVariable String id) {
        try {
            logger.info("Buscando paciente pelo ID: {}" + id);
            return ResponseEntity.ok().body(vacinaService.findByid(id));
        } catch (Exception ex) {
            logger.info("Erro ao buscar a vacina pelo ID: {}" + id);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar a vacina", ex);
        }
    }

    @PostMapping("api/vacinas")
    public Vacina registrarVacina(@RequestBody Vacina vacinaDTO) {
        try {

            return vacinaService.registrarVacina(vacinaDTO);

        } catch (Exception ex) {
            logger.info("Erro ao processar a solicitação de inserção de vacina.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível registrar vacina", ex);
        }
    }

    @PostMapping("api/vacinas/vacinasmock")
    public ResponseEntity<Void> vacinasmock() {
        vacinaService.vacinasMock();
        return ResponseEntity.created(null).build();
    }


    @PutMapping("/api/vacinas/id}")
    public ResponseEntity<Vacina> atualizarVacina(@RequestBody Vacina VacinaDto, @PathVariable String id) {
        try {
            logger.info("Recebendo solicitação para atualizar vacina com ID: {}" + id);

            return ResponseEntity.ok().body(vacinaService.atualizarVacina(VacinaDto, id));
        } catch (Exception ex) {
            logger.info("Erro ao processar a solicitação de atualização da vacina.");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao excluir a vacina", ex);
        }
    }

    @DeleteMapping("/api/vacinas{id}")
    public ResponseEntity<String> deletarVacina(@PathVariable String id) {

        try {
            logger.info("Recebendo solicitação para excluir paciente com ID: {}" + id);

            vacinaService.deletarVacina(id);

            logger.info("Vacina excluída com sucesso.");

            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            logger.info("Erro ao processar a solicitação de exclusão do paciente.");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao excluir a vacina", ex);
        }
    }
}
