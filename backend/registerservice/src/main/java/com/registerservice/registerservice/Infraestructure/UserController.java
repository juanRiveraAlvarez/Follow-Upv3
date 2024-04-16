package com.registerservice.registerservice.Infraestructure;

import com.registerservice.registerservice.Application.*;
import com.registerservice.registerservice.Domain.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

  private Register registerService;
  private ExistEmailExeption existEmailExeption;

  public UserController(Register registerService, ExistEmailExeption existEmailExeption){
    this.registerService = registerService;
    this.existEmailExeption = existEmailExeption;
  }

  @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> Register(@RequestBody User user){
     if(registerService.RegisterUser(user)){
       return ResponseEntity.ok("Creado con exito");
     }else{
       return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(existEmailExeption.getMessage());
     }

  }
}
