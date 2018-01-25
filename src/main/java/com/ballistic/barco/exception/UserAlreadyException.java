package com.ballistic.barco.exception;

/**
 * Created by Nabeel on 1/24/2018.
 */
public class UserAlreadyException extends RuntimeException {

    private String message;

    public UserAlreadyException(String message) {
        this.message = message;
    }

    public UserAlreadyException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public UserAlreadyException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public UserAlreadyException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public UserAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
