package com.authservice.authservice.Application;

import com.authservice.authservice.Infraestructure.AuthResponse;
import com.authservice.authservice.Infraestructure.LoginRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice.authservice.Domain.*;

@Service
public class AuthServiceImp implements AuthService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtServiceImp jwtServiceImp;

    public AuthServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtServiceImp jwtServiceImp){
      this.userRepository = userRepository;
      this.passwordEncoder = passwordEncoder;
      this.jwtServiceImp = jwtServiceImp;
    }

    @Override 
    public AuthResponse login(LoginRequest request){
      User usuario = userRepository.findByEmail(request.getEmail());
        if(usuario != null && passwordEncoder.matches(request.getPassword(), usuario.getPassword())){
            return AuthResponse.builder().token(jwtServiceImp.getToken(usuario)).build();
      }else {
          return null;
      }
    }
}
