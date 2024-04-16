package com.registerservice.registerservice.Application;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.registerservice.registerservice.Domain.*;

@Service
public class Register implements RegisterService{

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  public Register(UserRepository userRepository, PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public boolean RegisterUser(User user){
        if(this.userRepository.existsByEmail(user.getEmail())) {
          return false;
        }else{
          user.setPassword(passwordEncoder.encode(user.getPassword()));
          userRepository.save(user); 
          return true;
        }
   } 
}
