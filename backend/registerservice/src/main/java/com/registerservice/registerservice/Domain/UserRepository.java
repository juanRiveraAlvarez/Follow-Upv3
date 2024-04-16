package com.registerservice.registerservice.Domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
  List<User> findAll();
  boolean existsByEmail(String email);
}
