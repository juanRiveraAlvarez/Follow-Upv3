package com.registerservice.registerservice.Application;

import com.registerservice.registerservice.Infraestructure.AuthResponse;
import com.registerservice.registerservice.Infraestructure.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.registerservice.registerservice.Domain.*;
import com.registerservice.registerservice.Infraestructure.AuthResponse;

@Service
public class RegisterServiceImp implements RegisterService{

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private JwtServiceImp jwtServiceImp;

  public RegisterServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder,JwtServiceImp jwtServiceImp){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtServiceImp = jwtServiceImp;
  }

  @Override
  public AuthResponse RegisterUser(RegisterRequest request){
        if(this.userRepository.existsByEmail(request.getEmail())) {
            return null;
        }else{
            User user = userRepository.save(User.builder()
                    .email(request.getEmail())
                    .nick(request.getNick())
                    .name(request.getName())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build());
            AuthResponse authResponse = AuthResponse.builder()
                    .token(jwtServiceImp.getToken(user))
                    .email(request.getEmail())
                    .nick(request.getNick())
                    .name(request.getName())
                    .build();
            return authResponse;
        }
   } 
}
