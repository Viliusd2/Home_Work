package org.example.eshop.user.service;

import org.example.eshop.user.dto.UserDto;
import org.example.eshop.user.entity.Authority;
import org.example.eshop.user.entity.User;
import org.example.eshop.user.repository.AuthorityRepository;
import org.example.eshop.user.repository.UserRepository;
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
