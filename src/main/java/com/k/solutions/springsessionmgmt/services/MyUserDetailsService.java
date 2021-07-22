package com.k.solutions.springsessionmgmt.services;

import com.k.solutions.springsessionmgmt.models.MyUserDetails;
import com.k.solutions.springsessionmgmt.models.User;
import com.k.solutions.springsessionmgmt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOp = this.userRepository.findByUsername(username);
        if(userOp.isPresent()) {
            return new MyUserDetails(userOp.get());
        } else {
            throw new BadCredentialsException("Invalid Credentials");
        }
    }
}
