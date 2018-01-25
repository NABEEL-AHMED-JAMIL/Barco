package com.ballistic.barco.service.authorization;

import com.ballistic.barco.domain.auth.User;

/**
 * Created by Nabeel on 1/22/2018.
 */
public interface IAuthorizationService {

    public String register(User user);
    public String forgotPassword(String email);
    public String activated(String activationKey, String email);

}
