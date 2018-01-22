package com.ballistic.barco.captcha.exception;

/**
 * Created by Nabeel on 1/21/2018.
 */
public final class ReCaptchaUnavailableException extends RuntimeException {

    public ReCaptchaUnavailableException(final String message, final Throwable cause) {
        super(message, cause);
    }

}