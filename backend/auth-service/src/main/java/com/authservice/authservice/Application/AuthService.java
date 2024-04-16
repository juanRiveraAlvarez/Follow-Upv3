package com.authservice.authservice.Application;

import com.authservice.authservice.Infraestructure.AuthResponse;
import com.authservice.authservice.Infraestructure.LoginRequest;

public interface AuthService {
  AuthResponse login(LoginRequest request);
}
