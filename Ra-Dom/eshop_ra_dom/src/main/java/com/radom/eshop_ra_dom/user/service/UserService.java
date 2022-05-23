package com.radom.eshop_ra_dom.user.service;

import com.radom.eshop_ra_dom.user.dto.UserDto;
import com.radom.eshop_ra_dom.user.entity.User;
import com.radom.eshop_ra_dom.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public void register(UserDto userDto) {
        userRepository.save(User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phoneNumber(userDto.getPhoneNumber())
                .zipCode(userDto.getZipCode())
                .password(userDto.getPassword()) //FIXME: do not save as plain text for security reason
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findUserByEmailWithAuthorities(username)
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
    }

}
