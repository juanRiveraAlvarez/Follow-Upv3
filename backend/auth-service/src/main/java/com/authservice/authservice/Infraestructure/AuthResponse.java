package com.authservice.authservice.Infraestructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    String token;
}
