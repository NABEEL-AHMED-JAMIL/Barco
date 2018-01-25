package com.ballistic.barco.service.authorization;

import com.ballistic.barco.domain.auth.User;
import com.ballistic.barco.exception.UserAlreadyException;
import com.ballistic.barco.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nabeel on 1/22/2018.
 */
@Service
public class AuthorizationServiceImpl implements IAuthorizationService {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public String register(User user) {

        log.info("Start.....register....new....user.....process");
        if (user(user.getEmail()) != null) {
            throw new UserAlreadyException(user.getEmail(), "Already their");
        }
        this.userRepository.save(user);
        log.info("End.....register....new....user.....process");
        return "{"+"status"+":"+"save"+"}";
    }

    @Override
    public String forgotPassword(String email) {

        User user = user(email);
        if(user == null) {
            throw new UsernameNotFoundException("User with " + email + " Not Found");
        }
        return "{"+"status"+":"+"check email"+"}";
    }

    @Override
    public String activated(String activationKey, String email) {

        return null;
    }

    private User user(String email) { return this.userRepository.findByEmail(email); }

}
