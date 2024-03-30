package com.authservice.authservice.Application;

import org.springframework.stereotype.Service;

import com.authservice.authservice.Domain.*;

@Service
public class SearchServiceImpl implements SearchService{

    private UserRepository userRepository;
    public SearchServiceImpl(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    @Override
    public User searchService(long id){
      return this.userRepository.findById(id);
    }
}
