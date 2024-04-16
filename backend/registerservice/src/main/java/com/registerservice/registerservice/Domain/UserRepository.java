package com.registerservice.registerservice.Domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
  User save(UserDetailsService user);
  Boolean existsByEmail(String email);

  User findByEmail(String email);
}
