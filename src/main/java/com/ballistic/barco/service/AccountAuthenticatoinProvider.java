package com.ballistic.barco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 1/16/2018.
 */
@Component
public class AccountAuthenticatoinProvider extends AbstractUserDetailsAuthenticationProvider {

    private final Logger log = LoggerFactory.getLogger(AccountAuthenticatoinProvider.class);

    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * A PasswordEncoder instance to hash clear test password values.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        log.info("> Additional Authentication Checks");

        if(usernamePasswordAuthenticationToken.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials mya not be null.");
        }
        if(!passwordEncoder.matches((String) usernamePasswordAuthenticationToken.getCredentials(), userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid Credentials");
        }
        log.info("< Additional Authentication Checks");
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {
        log.info("> retrieveUser");
        UserDetails userDetails = userDetailsService.loadUserByUsername(s);
        log.debug("< retrieveUser");
        return userDetails;
    }

}
