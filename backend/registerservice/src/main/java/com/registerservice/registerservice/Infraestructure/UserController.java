package com.registerservice.registerservice.Infraestructure;

import com.registerservice.registerservice.Application.*;
import com.registerservice.registerservice.Domain.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

  private RegisterServiceImp registerService;

  public UserController(RegisterServiceImp registerService){
    this.registerService = registerService;
  }

  @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthResponse> Register(@RequestBody RegisterRequest request){
      AuthResponse authResponse = registerService.RegisterUser(request);
     if(authResponse != null){
       return ResponseEntity.ok(authResponse);
     }else{
       return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
     }

  }
}
