package org.example.eshop.controller;

import org.example.eshop.user.dto.UserDto;
import org.example.eshop.user.service.RegistrationService;
import org.example.eshop.validator.spring.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static org.example.eshop.EshopEndpoints.*;

@Controller
@RequiredArgsConstructor
public class UserController{

    private final UserValidator validator;
    private final RegistrationService registrationService;

    @GetMapping(USERS_REGISTER_PATH)
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());

        return "/user/user";
    }

    @PostMapping(USERS_REGISTER_PATH)
    public String register(@Valid UserDto userDto, BindingResult errors) {
        validator.validate(userDto, errors);
        if (errors.hasErrors()) {
            return "/user/user";
        }

        registrationService.register(userDto);

        return "redirect:" + PUBLIC_WORKSPACE+"/";
    }

}
