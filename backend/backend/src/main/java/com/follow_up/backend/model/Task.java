package com.follow_up.backend.model;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Integer idTask;

  @OneToMany(mappedBy = "task")
  private List<Register> registers = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "idUser", nullable = false)
  private User user;

  @Column(length = 50, nullable = false)
  private String titulo;

  @Column(columnDefinition = "TEXT")
  private String descripcion;

  @Column(length = 50, nullable = false)
  private boolean activo;
}
