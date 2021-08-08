package com.placeur.foundation.service;


import com.placeur.foundation.model.UserDto;
import com.placeur.foundation.model.UserProfile;
import com.placeur.foundation.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile saveUser(UserProfile user) {
        log.info("Inside saveUser of FoundationService");

        return userRepository.save(user);
    }

    public List<UserProfile> findAllUser() {
        log.info("Inside saveDepartment of DepartmentService");
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public UserProfile save(UserDto user) {
        UserProfile newUser = new UserProfile();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setMobile(user.getMobile());
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);
    }
}
