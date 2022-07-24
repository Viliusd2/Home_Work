package org.example.eshop.security.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshop.security.jwt.dto.login.LoginRequest;
import org.example.eshop.security.jwt.dto.login.LoginResponse;
import org.example.eshop.security.jwt.dto.user.UserRole;
import org.example.eshop.security.jwt.service.JwtProvider;
import org.example.eshop.swager.annotation.OpenApi;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@OpenApi
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest authRequest) throws Exception {
        return Optional.of(authenticate(authRequest.getUsername(), authRequest.getPassword()))
                .map(auth -> (UserRole) auth.getPrincipal())
                .map(principal -> ok(LoginResponse.of(
                        authRequest.getUsername(),
                        principal.getFullName(),
                        jwtProvider.getToken(principal),
                        jwtProvider.getExpiresInSeconds(),
                        getRoles(principal)
                )))
                .orElseThrow(() -> new BadCredentialsException("Authentication failed"));
    }
    private Set<String> getRoles(UserRole userRoleDto) {
        return userRoleDto.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }
    private Authentication authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
