package com.registerservice.registerservice;

import com.registerservice.registerservice.Security.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.registerservice.registerservice.Domain.*;

@SpringBootApplication
public class RegisterserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegisterserviceApplication.class, args);
	}

    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private UserRepository userRepository;
    public RegisterserviceApplication(JwtAuthenticationFilter jwtAuthenticationFilter, UserRepository userRepository){
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
                                .requestMatchers(HttpMethod.POST,"/save/**").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagmen -> sessionManagmen
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
}
