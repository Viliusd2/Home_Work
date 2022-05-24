package com.radom.eshop_ra_dom.user.dto;


import com.radom.eshop_ra_dom.validator.FieldsStringCompare;
import com.radom.eshop_ra_dom.validator.PhoneNumber;
import com.radom.eshop_ra_dom.validator.PhoneType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

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

    @NotBlank
    private String zipCode;

    @PhoneNumber(type = PhoneType.LOCAL)
    private String phoneNumber;

}
