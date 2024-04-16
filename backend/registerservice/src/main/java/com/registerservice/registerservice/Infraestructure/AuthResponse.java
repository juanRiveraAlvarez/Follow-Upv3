package com.registerservice.registerservice.Infraestructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    String name;
    String nick;
    String email;
    String token;
}
