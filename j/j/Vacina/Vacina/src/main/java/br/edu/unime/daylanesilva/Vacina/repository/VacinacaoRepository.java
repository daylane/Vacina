package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacinacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacinacaoRepository extends MongoRepository<Vacinacao, String> {
}
