package com.authservice.authservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import com.authservice.authservice.Domain.UserRepository;

import lombok.Data;

import com.authservice.authservice.Domain.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
public class AuthServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthServiceApplication.class, args);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authRequest -> authRequest
        .requestMatchers(HttpMethod.POST, "/search/**").permitAll()
        .anyRequest().authenticated())
        .formLogin(withDefaults()).build();

  }
  /*
   * @Bean
   * public CommandLineRunner demo(UserRepository repository){
   * return (args) ->{
   * repository.save(new User("Albert","123"));
   * };
   * }
   */
}
