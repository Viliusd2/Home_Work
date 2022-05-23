package com.radom.eshop_ra_dom.user.controller;

import com.radom.eshop_ra_dom.user.dto.UserDto;
import com.radom.eshop_ra_dom.user.service.UserService;
import com.radom.eshop_ra_dom.validator.spring.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.radom.eshop_ra_dom.EshopEndpoints.USERS_REGISTER_PATH;
import static com.radom.eshop_ra_dom.EshopEndpoints.USERS_ROOT_PATH;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserValidator validator;
    private final UserService userService;

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

        userService.register(userDto);

        return "redirect:" + USERS_ROOT_PATH;
    }
}
