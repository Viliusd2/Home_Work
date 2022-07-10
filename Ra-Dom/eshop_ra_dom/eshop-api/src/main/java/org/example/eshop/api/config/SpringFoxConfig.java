package org.example.eshop.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;


@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.eshop.api"))
                .build().securitySchemes(List.of(jwtAuthScheme()))
                .securityContexts(List.of(jwtAuthContext()));

    }
    private SecurityContext jwtAuthContext() {
        return SecurityContext.builder()
                .securityReferences(jwtAuthReference())
                .build();
    }
    private List<SecurityReference> jwtAuthReference() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
    }
    private SecurityScheme jwtAuthScheme() {
        return new ApiKey("JWT", HttpHeaders.AUTHORIZATION, "header");
    }
    private static ApiInfo getInfo(){
        return new ApiInfo(
                "Ra-Dom Eshop Rest Api Documentation",
                "This is simple documentation for Ra-Dom project",
                "0.0.1",
                "Ra-Dom Eshop terms of use Url",
                new Contact("Vilius Domarkas","www.radom.eu","radom@gmail.com"),
                "Eshop License",
                "License Url",
                Collections.emptyList()
        );
    }

}
