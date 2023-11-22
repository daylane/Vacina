package ApiVacina.service;


import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDate;
import java.util.*;



@Service
public class VacinaService {
    @Autowired
    static VacinaRepository vacinaRepository;

    private static final Logger logger = LoggerFactory.getLogger(VacinaService.class);


    public static List<Vacina> listarVacinas(String fabricante, String vacina) {


        List<Vacina> vacinas;

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
                throw new ResponseStatusException(HttpStatus.ACCEPTED, " Vacina não encontrada");
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



    }

    public Optional<Vacina> findByid(String id) {
        if (id.isEmpty()) {
            logger.info("Id não informado");
        }
        return vacinaRepository.findById(id);
    }



    public void vacinasMock(){
        List<Vacina> vacinaList = Arrays.asList(
                new Vacina("1","Pfizer","LF3343N", LocalDate.of(2023,12,31),2,15),
                new Vacina("2", "Moderna", "B84BF4", LocalDate.of(2022, 10, 13), 2, 28),
                new Vacina("3", "Johnson & Johnson", "N49FNKGH", LocalDate.of(2023, 4, 21), 1, 0),
                new Vacina("4", "Generic Pharma", "DB4-D43", LocalDate.of(2023, 12, 31), 3, 4)
                );
        vacinaList.forEach(vacina -> vacinaRepository.insert(vacina));
    }

    //pane no getLote -não sei por que
/*    public Vacina registrarVacina(Vacina vacina){
        List<Vacina> vacinas = new ArrayList<>();
        for(Vacina vacinaExistente : this.vacinas){
            if (vacina.getTotalDoses() > 1 && vacina.getIntervaloAplicacao() => 0) {
                throw new IllegalArgumentException("Os valores acerca do numero de doses e o intervalos entre as aplicações não pode ser nulos");
                logger.info("Não foi possivel registrar a vacina");
            }
            if (vacinaExistente.getLote().equals(vacinas.getLote())){
                throw new IllegalArgumentException("A vacina já foi registrada!");

            }
        }
      return vacinaRepository.insert(vacina);
    }*/

    public void deletarVacina(String id){
        if (id.isEmpty()) {
            logger.info("Id não informado");
        }
        //colocar validação para caso a vacina não existir voltar um not found

        Optional<Vacina> optionalVacina = findByid(id);
        if (optionalVacina.isPresent()) {
            vacinaRepository.delete(optionalVacina.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada");
        }
    }

    public Vacina atualizarVacina(Vacina vacinaDto, String id) {
        return null;
    }

    /*
    public void atualizarVacina(Vacina novaVacina, String id) throws Exception{
        Optional<Vacina> vacina = findByid(id);

        vacina.setFabricante(novaVacina.getFabricante());
        vacina.setLote(novaVacina.getLote());
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


            return Collections.singletonList(vacinaRepository.save(vacinaExistente));
        } else {
            return null;
        }*/

    }





