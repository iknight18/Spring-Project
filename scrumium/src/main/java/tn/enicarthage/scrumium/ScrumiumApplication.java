package tn.enicarthage.scrumium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrumiumApplication {

	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	public static void main(String[] args) {
		SpringApplication.run(ScrumiumApplication.class, args);
	}

}
