package com.registerservice.registerservice.Application;

import org.springframework.stereotype.Component;

@Component
public class ExistEmailExeption extends Exception{
  public ExistEmailExeption(){
    super("Ya existe una cuenta con ese email");
  }
}
