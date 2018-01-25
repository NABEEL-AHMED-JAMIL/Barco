package com.ballistic.barco.assemblers;

import com.ballistic.barco.domain.auth.User;
import com.ballistic.barco.service.Encryption;
import com.ballistic.barco.vo.ResetPasswordVo;
import com.ballistic.barco.vo.UserRegistrationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 1/22/2018.
 */
@Component("authorizationAssemblerImpl")
public class AuthorizationAssemblerImpl implements IAuthorizationAssembler {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationAssemblerImpl.class);

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Override
    public User toUser(UserRegistrationVo registrationVo) {

        log.info("Start convert from Vo to User");
        User user = new User();
        user.setFirstname(registrationVo.getFirstname());
        user.setLastname(registrationVo.getLastname());
        user.setUsername(registrationVo.getUsername());
        user.setEmail(registrationVo.getEmail());
        user.setPassword(passwordEncoder().encode(registrationVo.getPassword()));
        user.setActivated(registrationVo.getActivated());
        user.setAuthoritys(registrationVo.getAuthoritys());
        user.setActivationKey(Encryption.encryPtion(user.getEmail()));
        user.setResetPasswordKey(Encryption.encryPtion(user.getEmail()));
        log.info("End convert from Vo to User");

        return user;

    }

    @Override
    public User toUser(ResetPasswordVo resetPasswordVo) {

        return null;
    }


}
