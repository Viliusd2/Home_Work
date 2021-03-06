package org.example.eshop.security.jwt.validation;

import org.example.eshop.security.jwt.dto.user.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "userRegistrationForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "userRegistrationForm.surname");
    }
}
