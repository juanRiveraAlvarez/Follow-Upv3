package com.registerservice.registerservice.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name="UserT")
public class User{

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String name;
    private String password;
    private String nick;
    private String email;

}
