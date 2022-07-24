package org.example.eshop.security.jwt.dto.login;

import lombok.Value;

import java.util.Set;

@Value(staticConstructor = "of")
public class LoginResponse {
    String username;
    String fullName;
    String jwtToken;
    Long jwtTokenExpiresIn;
    Set<String> roles;

}
