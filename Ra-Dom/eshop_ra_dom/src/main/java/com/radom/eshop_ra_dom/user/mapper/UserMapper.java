package com.radom.eshop_ra_dom.user.mapper;


import com.radom.eshop_ra_dom.user.dto.UserDto;
import com.radom.eshop_ra_dom.user.dto.UserRole;
import com.radom.eshop_ra_dom.user.entity.Authority;
import com.radom.eshop_ra_dom.user.entity.User;
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
                        .zipCode(userEntity.getZipCode())
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
