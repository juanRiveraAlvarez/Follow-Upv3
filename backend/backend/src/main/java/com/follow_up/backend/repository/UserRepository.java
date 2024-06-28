package com.follow_up.backend.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.follow_up.backend.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
  List<User> findAll();
}
