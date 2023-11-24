package ApiVacina.service;

import ApiVacina.repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import ApiVacina.exceptions.DataValidadeException;
import ApiVacina.exceptions.LoteDuplicadoException;
import ApiVacina.exceptions.VacinaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    private final Logger logger = LoggerFactory.getLogger(VacinaService.class);

    public List<Vacina> listarVacinas(String fabricante, String vacina) {
        List<Vacina> vacinas;

        if (fabricante != null && vacina != null) {
            logger.info("Pesquisando fabricante e vacina.");
            vacinas = vacinaRepository.findByFabricanteAndVacina(fabricante, vacina);
        } else if (fabricante != null) {
            logger.info("Pesquisando fabricante.");
            vacinas = vacinaRepository.findByFabricante(fabricante);
        } else if (vacina != null) {
            logger.info("Pesquisando vacina.");
            vacinas = vacinaRepository.findByVacina(vacina);
        } else {
            logger.info("Pesquisando tudo.");
            vacinas = vacinaRepository.findAll();
        }
        if (vacinas.isEmpty()) {
            logger.info("Nenhuma vacina encontrada.");
        }

        return vacinas;
    }

    public Vacina registrarVacina(Vacina vacina) throws VacinaNotFoundException {
        LocalDate dataValidade = vacina.getDataValidade();
        if (dataValidade != null && dataValidade.isBefore(LocalDate.now())) {
            throw new DataValidadeException("A data de validade não pode ser no passado.");
        }
        if (vacinaRepository.existsByLote(vacina.getLote())) {
            throw new LoteDuplicadoException("Já existe uma vacina com o mesmo numero de lote: " + vacina.getLote());
        }
        try {
            vacinaRepository.insert(vacina);
            return vacina;
        } catch (Exception ex) {
            throw new VacinaNotFoundException();
        }

    }
    public void mockVacinas() {
        List<Vacina> vacinasmock = Arrays.asList(
                new Vacina("NEOPHAMA","B12","B49NDF",LocalDate.of(2024, 2, 3),2,15),
                new Vacina("MODERNA","INFLUENZA12", "NC93-AB1", LocalDate.of(2024, 3, 21), 2, 31),
                new Vacina("JOHNSON & JOHNSON","OST21", "DFSD-DN493", LocalDate.of(2025, 9, 1), 1, 0),
                new Vacina("ASTRAZENECA","NOVAX","AZ45678", LocalDate.of(2024, 10, 1), 2, 50)
        );


        vacinasmock.forEach(vacina -> vacinaRepository.insert(vacinasmock));
    }

    public void deletarVacina(String id) throws VacinaNotFoundException {
        Optional<Vacina> optionalVacina = findByid(id);
        optionalVacina.ifPresent(value -> vacinaRepository.delete(value));
    }

    public Optional<Vacina> findByid(String id) throws VacinaNotFoundException {
        Optional<Vacina> vacinaOptional = vacinaRepository.findById(id);
        if (vacinaOptional.isPresent()) {
            return vacinaOptional;
        } else {
            throw new VacinaNotFoundException();
        }
    }

    public Vacina atualizarVacina(Vacina vacina, String id) throws VacinaNotFoundException {
        Optional<Vacina> optionalVacina = findByid(id);

        if (optionalVacina.isPresent()) {
            Vacina vacinaExistente = optionalVacina.get();
            LocalDate novaDataValidade = vacina.getDataValidade();
            if (novaDataValidade != null && novaDataValidade.isBefore(LocalDate.now())) {
                throw new DataValidadeException("A data de validade não pode ser no passado.");
            }
            if (!vacinaExistente.getLote().equals(vacina.getLote())
                    && vacinaRepository.existsByLote(vacina.getLote())) {
                throw new LoteDuplicadoException(
                        "Já existe uma vacina com o mesmo número de lote: " + vacina.getLote());
            }
            vacinaExistente.setVacina(vacina.getVacina());
            vacinaExistente.setFabricante(vacina.getFabricante());
            vacinaExistente.setLote(vacina.getLote());
            vacinaExistente.setDataValidade(novaDataValidade);
            vacinaExistente.setNumeroDoses(vacina.getNumeroDoses());
            vacinaExistente.setIntervaloMinimoEntreDoses(vacina.getIntervaloMinimoEntreDoses());

            return vacinaRepository.save(vacinaExistente);
        } else {
            throw new VacinaNotFoundException();
        }
    }

}
