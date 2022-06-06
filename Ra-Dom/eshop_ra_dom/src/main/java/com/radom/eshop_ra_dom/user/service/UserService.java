package com.radom.eshop_ra_dom.user.service;

import com.radom.eshop_ra_dom.user.entity.User;
import com.radom.eshop_ra_dom.user.mapper.UserMapper;
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
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findUserByEmailWithAuthorities(username)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
    }

    public User checkAndReturnUserIfExists(String username) throws UsernameNotFoundException {
        return  userRepository.findUserByEmail(username);
    }



}
