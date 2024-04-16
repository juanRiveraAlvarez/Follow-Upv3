package com.registerservice.registerservice.Infraestructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    String name;
    String password;
    String nick;
    String email;
}
