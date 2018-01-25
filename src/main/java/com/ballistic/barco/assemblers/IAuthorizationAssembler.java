package com.ballistic.barco.assemblers;

import com.ballistic.barco.domain.auth.User;
import com.ballistic.barco.vo.ResetPasswordVo;
import com.ballistic.barco.vo.UserRegistrationVo;

/**
 * Created by Nabeel on 1/22/2018.
 */
public interface IAuthorizationAssembler {

    User toUser(UserRegistrationVo registrationVo);
    User toUser(ResetPasswordVo resetPasswordVo);
}
