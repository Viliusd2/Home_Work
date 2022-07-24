package org.example.eshop.security.jwt.controller;


import lombok.RequiredArgsConstructor;
import org.example.eshop.security.jwt.dto.user.UserDto;
import org.example.eshop.security.jwt.service.RegistrationService;
import org.example.eshop.security.jwt.validation.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class UserController {

    private final UserValidator validator;

    private final RegistrationService registrationService;

    @PostMapping()
    public ResponseEntity<Void> register(@RequestBody @Valid UserDto userDto, BindingResult errors) {
        validator.validate(userDto, errors);
        if (errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
        registrationService.register(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
