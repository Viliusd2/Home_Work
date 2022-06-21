package org.example.eshop.user.dto;


import org.example.eshop.validator.FieldsStringCompare;
import org.example.eshop.validator.PhoneNumber;
import org.example.eshop.validator.PhoneType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@FieldsStringCompare(
        firstField = "password",
        secondField = "repeatedPassword",
        message = "{validate.string.fields}")
public class UserDto{

    private String name;
    private String surname;

    @NotBlank
    @Email
    private String email;

    @Size(min = 6, max = 255)
    private String password;

    @Size(min = 6, max = 255)
    private String repeatedPassword;

    @PhoneNumber(type = PhoneType.LOCAL)
    private String phoneNumber;

}
