package br.edu.unime.daylanesilva.Vacina.service;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepositoy;

    public List<Vacina> obterVacinas() {
        return vacinaRepositoy.findAll();
    }

    public void registrarVacina(Vacina vacina){
        vacinaRepositoy.save(vacina);
    }

    //vacinas fake
    public void mockVacinasFake() {
        List<Vacina> mockVacinasFake = Arrays.asList(
                new Vacina("Sinopharm", "MFG2023-ABC123", LocalDate.of(2019, 12, 12), 3, 45),
                new Vacina("AstraZeneca ", "XYZ456-L210923", LocalDate.of(2021, 8, 17), 2, 60),
                new Vacina("Generic Pharma", "PHARMA2023-BATCH42-23SEP", LocalDate.of(2022, 6, 23), 1, 90),
                new Vacina("Moderna", "LOT789-XY2023-05", LocalDate.of(2022, 5, 14), 2, 45),
                new Vacina("Johnson & Johnson", "PROD-1234-ABC-210930", LocalDate.of(2021, 7, 28), 3, 30)
        );
        mockVacinasFake.forEach(this::registrarVacina);
    }

    public void deletarVacina(String id) {
        Optional<Vacina> optionalVacina = obterVacinasPeloId(id);
        vacinaRepositoy.deleteById(id);
    }

    public Optional<Vacina> obterVacinasPeloId(String id) {
        return vacinaRepositoy.findById(id);
    }

    public Vacina update(Vacina novaVacina, String id) {
        Optional<Vacina> optionalVacina = obterVacinasPeloId(id);
        return vacinaRepositoy.save(optionalVacina.get());
    }
}

