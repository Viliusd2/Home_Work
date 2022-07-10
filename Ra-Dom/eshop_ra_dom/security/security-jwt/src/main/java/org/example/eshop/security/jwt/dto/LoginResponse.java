package org.example.eshop.security.jwt.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class LoginResponse {
    String username;
    String fullName;
    String jwtToken;
    Long jwtTokenExpiresIn;

}
