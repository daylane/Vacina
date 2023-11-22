package ApiVacina.service;


import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import com.sun.source.tree.TryTree;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
import org.springframework.web.server.ResponseStatusException;
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> Stashed changes

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.bouncycastle.asn1.x500.style.BCStyle.O;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    private Logger logger = LoggerFactory.getLogger(VacinaService.class);

<<<<<<< Updated upstream
    public List<Vacina> listarVacinas(String fabricante, String vacina) {
=======
    @Transactional(readOnly = true)
    public List<Vacina> listarVacinas() {
>>>>>>> Stashed changes
        List<Vacina> vacinas;

<<<<<<< Updated upstream
        if(fabricante != null && vacina != null)
        {
            logger.info("Pesquisando fabricante e vacina." );

            vacinas = vacinaRepository.findByFabricanteAndVacina(fabricante, vacina);
            if(vacinas.isEmpty())
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Vacina não encontrada");
            }
            return vacinas;
        }
        else if(fabricante != null)
        {
            logger.info("Pesquisando fabricante." );
            vacinas = vacinaRepository.findByFabricante(fabricante);

            if(vacinas.isEmpty())
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Vacina não encontrada");
            }
            return vacinas;
        }
        else if(vacina != null)
        {
            logger.info("Pesquisando vacina." );
            vacinas = vacinaRepository.findByVacina(vacina);
            if(vacinas.isEmpty())
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Vacina não encontrada");
            }
            return vacinas;
        }
        else{
            logger.info("Pesquisando tudo." );
            vacinas = vacinaRepository.findAll();
            if(vacinas.isEmpty())
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Vacina não encontrada");
            }
            return vacinas;
        }



        //logger.info("retornou " + vacinas.get(0));

        /*return vacinas.stream().map(vacinadto -> {
            VacinaDto vacinaDto = new VacinaDto();
            vacinaDto.setVacina(vacinadto.getVacina());
            vacinaDto.setFabricante(vacinadto.getFabricante());
            vacinaDto.setTotal_de_doses(vacinadto.getNumeroDoses());
            vacinaDto.setIntervalo_entre_doses(vacinadto.getIntervaloMinimoEntreDoses());
            return vacinaDto;
        }).collect(Collectors.toList());*/
=======
        return vacinas;
>>>>>>> Stashed changes

    }

    @Transactional(readOnly = true)
    private Optional<Vacina> findByid(String id) throws Exception {
        return findByid(id);
    }

    public void vacinasMock() {
        List<Vacina> vacinasmock = Arrays.asList(
                new Vacina("1", "Pfizer", "LF3343N", LocalDate.of(2023, 12, 31), 2, 50),
                new Vacina("2", "Moderna", "B84BF4", LocalDate.of(2022, 10, 13), 2, 28),
                new Vacina("3", "Johnson & Johnson", "N49FNKGH", LocalDate.of(2023, 4, 21), 1, 0),
                new Vacina("4", "Generic Pharma", "DB4-D43", LocalDate.of(2023, 12, 31), 3, 4)

        );
        vacinasmock.forEach(vacina -> vacinaRepository.insert(vacina));
    }
    public Vacina registrarVacina(Vacina vacina) throws Exception {
                 if (vacina.getTotal_de_doses() > 1 && vacina.getIntervalo_entre_doses() == null) {
                throw new Exception();
                logger.info("Não foi possivel registrar a vacina");
        }
                 return vacinaRepository.insert(vacina);
    }
    public void atualizarVacina(Vacina novaVacina, String id) throws Exception{
        Optional<Vacina> vacina = findByid(id);

        vacina.setFabricante(novaVacina.getFabricante());
        vacina.setLote(novaVacina.getLote());
    }

    public void deletarVacina(String id) throws Exception {
        Optional<Vacina> optionalVacina = findByid(id);
        optionalVacina.ifPresent(value -> vacinaRepository.delete(value));
    }
<<<<<<< Updated upstream

    public Optional<Vacina> findByid(String id) {
        if (id == null) {
            return null;
        }
        return vacinaRepository.findById(id);
    }


    public Vacina atualizarVacina(Vacina novaVacina, String id) {

        Optional<Vacina> optionalVacina = findByid(id);

        if (optionalVacina.isPresent()) {
            Vacina vacinaExistente = optionalVacina.get();

            vacinaExistente.setFabricante(novaVacina.getFabricante());
            vacinaExistente.setLote(novaVacina.getLote());
            vacinaExistente.setDataValidade(novaVacina.getDataValidade());
            vacinaExistente.setNumeroDoses(novaVacina.getNumeroDoses());
            vacinaExistente.setIntervaloMinimoEntreDoses(novaVacina.getIntervaloMinimoEntreDoses());


            return vacinaRepository.save(vacinaExistente);
        } else {
            return null;
        }

    }

 /*   public void vacinasMock(){
        List<Vacina> vacinasmock(){
            new Vacina("Pfizer","LF3343N",LocalDate.of(2023,12,31),2,50);
            new Vacina("Moderna", "B84BF4", LocalDate.of(2022, 10, 13), 2, 28);
            new Vacina("Johnson & Johnson", "N49FNKGH", LocalDate.of(2023, 4, 21), 1, 0);
            new Vacina("Generic Pharma", "DB4-D43", LocalDate.of(2023, 12, 1O), 3, 4)

        }
        vacinasmock.forEach(vacina -> vacinaRepository.insert(vacina));
    }*/
    }
=======
}
>>>>>>> Stashed changes
