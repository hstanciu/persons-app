package biz.korwin.web.config;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import biz.korwin.web.persistence.PersonRepository;
import biz.korwin.web.persistence.domain.Person;

@Configuration
public class PersistenceConfig {
	
	@Bean
    CommandLineRunner init(PersonRepository personRepository) {
        return args -> {
            Stream.of(new Person("John", "Doe"), new Person("Jane", "Doe"), new Person("Jebediah", "Freebit"))
            .forEach(p -> {
                personRepository.save(p);
            });
        };
    }
}
