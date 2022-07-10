package org.example.eshop.security.jwt.dto;


import lombok.Builder;
import lombok.Getter;



@Builder
@Getter
public class UserDto{

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;

}
