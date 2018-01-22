package com.ballistic.barco.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nabeel on 1/22/2018.
 */
public class ValidationUtil {

    public static List<String> fromBindingErrors(Errors errors) {
        List<String> validErrors = new ArrayList<String>();
        for (ObjectError objectError : errors.getAllErrors()) {
            validErrors.add(objectError.getDefaultMessage());
        }
        return validErrors;
    }
}
