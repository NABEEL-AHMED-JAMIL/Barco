package com.ballistic.barco.captcha.exception;

/**
 * Created by Nabeel on 1/21/2018.
 */
public final class ReCaptchaUnavailableException extends RuntimeException {

    public ReCaptchaUnavailableException() {}
    public ReCaptchaUnavailableException(String message) {
        super(message);
    }
    public ReCaptchaUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
    public ReCaptchaUnavailableException(Throwable cause) {
        super(cause);
    }
    public ReCaptchaUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}