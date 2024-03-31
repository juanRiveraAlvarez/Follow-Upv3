package com.authservice.authservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.authservice.authservice.Domain.UserRepository;
import com.authservice.authservice.Domain.User;

@SpringBootApplication
public class AuthServiceApplication {

  private static final Logger log = LoggerFactory.getLogger(AuthServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(UserRepository repository){
      return (args) ->{
        repository.save(new User("Albert","123"));
      };
    }
    

}
