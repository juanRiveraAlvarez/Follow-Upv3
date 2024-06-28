package com.follow_up.backend.model;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "UserT")
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Integer idUser;

  @OneToMany(mappedBy = "user")
  private List<Task> tasks = new ArrayList<>();

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 50, nullable = false)
  private String lastName;

  @Column(length = 50, nullable = false)
  private String password;

  @Column(length = 50, nullable = false)
  private String email;
}
