package com.registerservice.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class RegisterserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegisterserviceApplication.class, args);
	}

        @Bean
        public PasswordEncoder passwordEncoder(){
          return new BCryptPasswordEncoder();
        }

        @Bean 
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
              http
            .csrf().disable() // Desactivar CSRF para la simplicidad del ejemplo
            .authorizeRequests().anyRequest().permitAll();
            return http.build();
          }
}
