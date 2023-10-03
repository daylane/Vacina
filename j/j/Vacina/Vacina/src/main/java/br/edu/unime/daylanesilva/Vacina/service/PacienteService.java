package br.edu.unime.daylanesilva.Vacina.service;

import br.edu.unime.daylanesilva.Vacina.entity.Paciente;
import br.edu.unime.daylanesilva.Vacina.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> obterTodos(){
        return pacienteRepository.findAll();
    }
}
