package com.ballistic.barco.assemblers;

import com.ballistic.barco.domain.User;
import com.ballistic.barco.service.Encryption;
import com.ballistic.barco.vo.UserRegistrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 1/22/2018.
 */
@Component("authorizationAssemblerImpl")
public class AuthorizationAssemblerImpl implements IAuthorizationAssembler {

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Autowired
    private Encryption encryption;

    @Override
    public User toComment(UserRegistrationVo registrationVo) throws Exception {
        User user = new User();
        user.setFirstname(registrationVo.getFirstname());
        user.setLastname(registrationVo.getLastname());
        user.setUsername(registrationVo.getUsername());
        user.setEmail(registrationVo.getEmail());
        user.setPassword(passwordEncoder().encode(registrationVo.getPassword()));
        user.setActivated(registrationVo.getActivated());
        user.setAuthoritys(registrationVo.getAuthoritys());
        user.setActivationKey(encryption.encryPtion(user.getEmail()));
        user.setResetPasswordKey(encryption.encryPtion(user.getEmail()));

        return user;
    }
}
