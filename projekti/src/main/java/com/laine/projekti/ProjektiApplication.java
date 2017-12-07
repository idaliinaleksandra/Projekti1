package com.laine.projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.laine.projekti.domain.Hahmo;
import com.laine.projekti.domain.HahmoRepository;
import com.laine.projekti.domain.User;
import com.laine.projekti.domain.UserRepository;

@SpringBootApplication
public class ProjektiApplication {

private static final Logger log = LoggerFactory.getLogger(ProjektiApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(ProjektiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner hahmoDemo(HahmoRepository repository, UserRepository userrepository)  {
		return (args) -> {
			log.info("save data");
			repository.save(new Hahmo("Gordom", 37, 459, "siperiantiikeri"));
			repository.save(new Hahmo("Sniper", 29, 680, "valkomerikotka"));
			repository.save(new Hahmo("Teller", 26, 990, "juovahyeena"));
			repository.save(new Hahmo("Idan", 16, 998, "suistokrokotiili"));
			repository.save(new Hahmo("Junk", 24, 250, "syyriankarhu"));
			
			User user1 = new User("user", "$2a$10$8LXo1mEQCXgzEEh8vhCsd.79lNpP2bwOrS2aRfBsRC/O9c6z3qM2y", "USER");
			User user2 = new User("admin", "$2a$10$EO01TIsuCumWrdJBPulQve6Y5waNOV2iM6FEDgpr6PzunlWSl9z1m", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
			
			log.info("fetch all characters");
			for (Hahmo hahmo : repository.findAll()){
				log.info(hahmo.toString());
			}
		};
	}
}
