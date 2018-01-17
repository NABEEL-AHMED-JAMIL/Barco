package com.ballistic.barco.service;

import com.ballistic.barco.domain.User;
import com.ballistic.barco.exception.UserNotActivatedException;
import com.ballistic.barco.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nabeel on 1/11/2018.
 */
// No Issue work fine
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        log.info("login {}", login);
        String lowercaseLogin = login.toLowerCase();
        User userFromDatabase;
        if(lowercaseLogin.contains("@")) {
            log.info("email--- {}", login);
            userFromDatabase = userRepository.findByEmail(lowercaseLogin);
        } else {
            log.info("username--- {}", login);
            userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);
        }

        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        } else if (userFromDatabase.getAuthoritys() == null || userFromDatabase.getAuthoritys().isEmpty()) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " is not possible due to the authority null");
        } else if (!userFromDatabase.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " is not activated yet");
        }else {
            log.info("getting role--- {}", userFromDatabase.getAuthoritys().toString());
            Collection<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
            userFromDatabase.getAuthoritys().forEach(authority -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
                grantedAuthoritys.add(grantedAuthority);
            });
            return new org.springframework.security.core.userdetails.User(userFromDatabase.getUsername(),
                    userFromDatabase.getPassword(), grantedAuthoritys);
        }
    }
}

