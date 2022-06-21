package org.example.eshop.user.mapper;


import org.example.eshop.user.dto.UserDto;
import org.example.eshop.user.dto.UserRole;
import org.example.eshop.jpa.user.entity.Authority;
import org.example.eshop.jpa.user.entity.User;
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
