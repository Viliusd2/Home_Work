package org.example.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.example.eshop.EshopEndpoints.PUBLIC_WORKSPACE;

@Controller
public class WelcomePageController {
    @GetMapping(PUBLIC_WORKSPACE+"/")
    public String hello(){
        return "welcome/hello";
    }
}
