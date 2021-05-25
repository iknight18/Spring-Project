package tn.enicarthage.scrumium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ScrumiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrumiumApplication.class, args);
	}

}
