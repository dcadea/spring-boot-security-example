package com.personal.security.example.service.impl;

import com.personal.security.example.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public SecurityServiceImpl(final UserDetailsService userDetailsService,
                               final AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(final String username, final String password) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            getContext().setAuthentication(token);
        }
    }

    @Override
    public String authenticatedUsername() {
        return ofNullable(getContext().getAuthentication().getDetails())
                .filter(details -> details instanceof UserDetails)
                .map(userDetails -> (UserDetails) userDetails)
                .map(UserDetails::getUsername)
                .orElse(null);
    }

}
