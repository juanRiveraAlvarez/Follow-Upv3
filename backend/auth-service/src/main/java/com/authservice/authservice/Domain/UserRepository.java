package com.authservice.authservice.Domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
  User findById(long id);
}
