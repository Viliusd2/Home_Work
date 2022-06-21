package org.example.eshop.validator;

import org.example.eshop.user.dto.UserDto;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCompareValidator implements ConstraintValidator<PasswordCompare, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getPassword() != null
                && !userDto.getPassword().equals("")
                && userDto.getPassword().equals(userDto.getRepeatedPassword());
    }
}
