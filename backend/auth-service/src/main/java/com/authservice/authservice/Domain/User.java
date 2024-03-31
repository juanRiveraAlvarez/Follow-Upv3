package com.authservice.authservice.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserT")
public class User{

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String name;
    private String password;

    protected User(){}

    public User(String name, String password){
      this.name = name; 
      this.password = password;
    }

    public Long getId(){
      return this.id;
    }

    public String getName(){
      return this.name;
    }
    
    public String getPassword(){
      return this.password;
    }

    @Override
    public String toString(){
      return "Hola";
    }

}
