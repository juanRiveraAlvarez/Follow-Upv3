package com.authservice.authservice.Application;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    public String getToken(UserDetails user);
}
