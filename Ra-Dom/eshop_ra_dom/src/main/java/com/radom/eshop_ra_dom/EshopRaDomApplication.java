package com.radom.eshop_ra_dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class EshopRaDomApplication {

    public static void main(String[] args) {

        ConfigurableEnvironment envConfig = new StandardEnvironment();
        envConfig.addActiveProfile("dev");

        SpringApplication app = new SpringApplication(EshopRaDomApplication.class);
//        app.setEnvironment(envConfig);
        app.run(args);
    }

}
