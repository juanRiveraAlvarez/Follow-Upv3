package  com.follow_up.backend.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.follow_up.backend.repository.UserRepository;
import com.follow_up.backend.model.*;

@RestController
public class UserController{

  private final UserRepository userRepository;

  UserController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping("/")
  List<User> hola(){
    return userRepository.findAll();
  }
}
