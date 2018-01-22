package com.ballistic.barco.assemblers;

import com.ballistic.barco.domain.User;
import com.ballistic.barco.vo.UserRegistrationVo;

/**
 * Created by Nabeel on 1/22/2018.
 */
public interface IAuthorizationAssembler {

    public User toComment(UserRegistrationVo registrationVo) throws Exception ;
}
