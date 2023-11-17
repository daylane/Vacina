package br.edu.unime.daylanesilva.Vacina;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({ "br.edu.unime.daylaneSilva.Vacina.Service" })
@EnableMongoRepositories(basePackages = "br.edu.unime.daylaneSilva.Vacina.Repository")
@EntityScan("basePackages = br.edu.unime.daylaneSilva.vacina.Entity")
public class VacinaApplication {

	private static Looger logger = LoggerFactory.getLogger(VacinaApplication.class);

	public static void main(String[] args) {
		Logger.info("Iniciando a api de gerenciamento de vacinas");
		SpringApplication.run(VacinaApplication.class, args);
		Logger.info("A api de gerenciamento de vacinas está iniciada e pronta para receber requisições");
	}

}
