package com.radom.eshop_ra_dom.user.service;

import com.radom.eshop_ra_dom.user.dto.UserDto;
import com.radom.eshop_ra_dom.user.entity.Authority;
import com.radom.eshop_ra_dom.user.entity.User;
import com.radom.eshop_ra_dom.user.repository.AuthorityRepository;
import com.radom.eshop_ra_dom.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;


//Needed new repo because of beans clashing for passwordEncoder and UserDetailsService that already implemented that
@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(UserDto userDto) {

        userRepository.save(User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phoneNumber(userDto.getPhoneNumber())
                .zipCode(userDto.getZipCode())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .authorities(getDefaultAuthorityFromDB())
                .build());
    }


    private Set<Authority> getDefaultAuthorityFromDB(){
    return authorityRepository.findAll().stream()
            .filter(a -> a.getName().equals("USER"))
            .collect(Collectors.toUnmodifiableSet());
    }
}
