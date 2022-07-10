package org.example.eshop.security.jwt.mapper;


import org.example.eshop.security.jpa.entity.Authority;
import org.example.eshop.security.jpa.entity.User;
import org.example.eshop.security.jwt.dto.UserDto;
import org.example.eshop.security.jwt.dto.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserRole toDto(User userEntity){
        return UserRole.builder()
                .user(UserDto.builder()
                        .email(userEntity.getEmail())
                        .name(userEntity.getName())
                        .password(userEntity.getPassword())
                        .phoneNumber(userEntity.getPhoneNumber())
                        .surname(userEntity.getSurname())
                        .build())
                .roles(
                        userEntity.getAuthorities().stream()
                                .map(getAuthority())
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toUnmodifiableSet())
                )
                .build();
    }

    private Function<Authority, String> getAuthority() {
        return authority -> "ROLE_" + authority.getName();
    }
}
