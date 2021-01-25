package com.rest.webservices.RESTfulservicesforAngularToDoList.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "amandaw",
                "$2y$12$UcBbXfbhT8OAwEGhnYXP2e0GWXF8ShiYHUB89rOrdaPV5uFvi8t2u", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(2L, "happyKid",
                "$2y$12$yOcev5f/yCIpiCg7tCIM1O3T8nzB4LrJDkAiOvLI3cwMeEF9gr1gG", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}

