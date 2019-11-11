package com.climbing.zone.service;

import com.climbing.zone.domain.User;
import com.climbing.zone.domain.UserPrincipal;
import com.climbing.zone.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserPincipalDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //TODO si ici on ne trouve pas l'utilisateur aussi
        User user = this.userRepository.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
