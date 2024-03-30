package com.authservice.authservice.Infraestructure;

import com.authservice.authservice.Domain.*;
import com.authservice.authservice.Application.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

  private SearchServiceImpl searchServiceImpl;

  public UserController(SearchServiceImpl searchServiceImpl){
    this.searchServiceImpl = searchServiceImpl;
  }

  @GetMapping("/getById")
  public User getById(@RequestParam(value = "id") long id){
    return searchServiceImpl.searchService(id);
  }
}
