package com.follow_up.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Register")
public class Register{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Integer idRegister;

  @ManyToOne
  @JoinColumn(name = "idTask", nullable = false)
  private Task task;

  @Column(nullable = false)
  private LocalDateTime start;

  @Column(nullable = false)
  private LocalDateTime finish;
}
