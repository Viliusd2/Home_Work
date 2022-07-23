package org.example.eshop.security.jwt.controller;


import lombok.RequiredArgsConstructor;
import org.example.eshop.security.jwt.dto.UserDto;
import org.example.eshop.security.jwt.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;

    @PostMapping()
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) {

        registrationService.register(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
