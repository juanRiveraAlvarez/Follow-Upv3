package com.authservice.authservice;

import com.authservice.authservice.Security.JwtAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import com.authservice.authservice.Domain.UserRepository;
import com.authservice.authservice.Domain.User;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

        private JwtAuthenticationFilter jwtAuthenticationFilter;
        private UserRepository userRepository;
        public AuthServiceApplication(JwtAuthenticationFilter jwtAuthenticationFilter, UserRepository userRepository){
            this.jwtAuthenticationFilter=jwtAuthenticationFilter;
            this.userRepository = userRepository;
        }
        @Bean
        public PasswordEncoder passwordEncoder(){
          return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService userDetailService(){
            try{
                return  email -> userRepository.findByEmail(email);
            }catch (UsernameNotFoundException e){
                return null;
            }

        }

        @Bean
        public AuthenticationProvider authenticationProvider()
        {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userDetailService());
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return  authenticationProvider;
        }

        @Bean 
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
        {
            return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests( authRequest ->
                  authRequest
                    .requestMatchers(HttpMethod.POST,"/login/**").permitAll()
                    .anyRequest().authenticated()
                    )
                    .sessionManagement(sessionManagmen -> sessionManagmen
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    ).authenticationProvider(authenticationProvider())
                    .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                    .build();

        }
       /* @Bean
        public CommandLineRunner demo(UserRepository repository){
          return (args) ->{
            repository.save(new User("Albert","123"));
          };
        }
        */
  }   
