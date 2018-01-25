package com.ballistic.barco.exception;

import com.ballistic.barco.captcha.exception.ReCaptchaInvalidException;
import com.ballistic.barco.captcha.exception.ReCaptchaUnavailableException;
import com.ballistic.barco.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Nabeel on 1/22/2018.
 */
@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
        log.error("Exception........{}",MethodArgumentNotValidException.class);
        BindingResult result = ex.getBindingResult();
        ExceptionResponse response = getExceptionResponse("Validation Error","Invalid inputs.");
        response.setErrors(ValidationUtil.fromBindingErrors(result));
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(UserAlreadyException ex) {
        log.error("Exception........{}",UserAlreadyException.class);
        return new ResponseEntity<ExceptionResponse>(
                getExceptionResponse("Not Active", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotActivatedException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(UserNotActivatedException ex) {
        log.error("Exception........{}",UserNotActivatedException.class);
        return new ResponseEntity<ExceptionResponse>(
                getExceptionResponse("User Their", ex.getMessage()), HttpStatus.ALREADY_REPORTED);
    }


    @ExceptionHandler(ReCaptchaInvalidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(ReCaptchaInvalidException ex) {
        log.error("Exception........{}",ReCaptchaInvalidException.class);
        return new ResponseEntity<ExceptionResponse>(
                getExceptionResponse("ReCaptchaInvalidException", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ReCaptchaUnavailableException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(ReCaptchaUnavailableException ex) {
        log.error("Exception........{}",ReCaptchaUnavailableException.class);
        return new ResponseEntity<ExceptionResponse>(
                getExceptionResponse("ReCaptchaUnavailableException", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ExceptionResponse getExceptionResponse(String errorCode, String errorMessage) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);

        return response;
    }

}