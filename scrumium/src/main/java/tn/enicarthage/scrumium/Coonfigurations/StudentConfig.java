package tn.enicarthage.scrumium.Coonfigurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.enicarthage.scrumium.Domain.Student;
import tn.enicarthage.scrumium.Repositories.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student feres = new Student("Feres","feresnefzi@gmail.com", LocalDate.of(1997,6,20));
            Student alex = new Student("alex","alex@gmail.com", LocalDate.of(1997,7,20));
            repository.saveAll(List.of(feres,alex));
        };
    }
}
