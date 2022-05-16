package com.radom.eshop_ra_dom.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "welcome/hello";
    }
}
