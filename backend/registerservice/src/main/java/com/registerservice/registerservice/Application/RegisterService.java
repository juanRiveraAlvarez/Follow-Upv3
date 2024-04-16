package com.registerservice.registerservice.Application;

import com.registerservice.registerservice.Infraestructure.AuthResponse;
import com.registerservice.registerservice.Infraestructure.RegisterRequest;

public interface RegisterService {
    AuthResponse RegisterUser(RegisterRequest user);
}
