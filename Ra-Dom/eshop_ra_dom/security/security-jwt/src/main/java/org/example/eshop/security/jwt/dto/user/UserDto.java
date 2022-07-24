package org.example.eshop.security.jwt.dto.user;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Builder
@Getter
public class UserDto{

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 100)
    private String surname;

    @NotBlank
    @Email
    private String email;

    @Size(min = 6, max = 255)
    private String password;

    @NotBlank
    private String phoneNumber;

}
