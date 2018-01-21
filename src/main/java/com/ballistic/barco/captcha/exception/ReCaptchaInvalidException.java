package com.ballistic.barco.captcha.exception;

/**
 * Created by Nabeel on 1/21/2018.
 */
public final class ReCaptchaInvalidException extends RuntimeException {

    public ReCaptchaInvalidException() { super(); }
    public ReCaptchaInvalidException(final String message, final Throwable cause) { super(message, cause); }
    public ReCaptchaInvalidException(final String message) { super(message); }
    public ReCaptchaInvalidException(final Throwable cause) { super(cause); }

}
