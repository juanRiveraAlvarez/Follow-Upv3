package com.authservice.authservice.Infraestructure;

import com.authservice.authservice.Application.AuthServiceImp;
import com.authservice.authservice.Domain.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

@RestController
public class UserController{

  private AuthServiceImp authServiceImp;

  public UserController(AuthServiceImp authServiceImp){
    this.authServiceImp = authServiceImp;
  }

  @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthResponse> Login(@RequestBody LoginRequest request){
    if(authServiceImp.login(request) != null){
      return ResponseEntity.ok(authServiceImp.login(request));
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } 
  }
}
