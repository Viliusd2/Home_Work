package com.radom.eshop_ra_dom.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.radom.eshop_ra_dom.EshopEndpoints.PUBLIC_WORKSPACE;

@Controller
public class HelloController {
    @GetMapping(PUBLIC_WORKSPACE+"/")
    public String hello(){
        return "welcome/hello";
    }
}
