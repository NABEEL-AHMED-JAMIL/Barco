package com.ballistic.barco.exception;


import org.springframework.security.core.AuthenticationException;
/**
 * Created by Nabeel on 1/11/2018.
 */
public class UserNotActivatedException extends AuthenticationException {

    public UserNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }
    public UserNotActivatedException(String msg) {
        super(msg);
    }
}