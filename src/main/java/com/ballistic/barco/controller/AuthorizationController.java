package com.ballistic.barco.controller;

import com.ballistic.barco.captcha.service.ICaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import static com.ballistic.barco.util.ContentPathUtill.*;

/**
 * Created by Nabeel on 1/16/2018.
 */

@RestController
@RequestMapping(value = AUTH)
public class AuthorizationController {

    public String returnString = "{\"success\": true,   \"payload\": \"{}!\", " + "}";

    @Autowired
    private ICaptchaService iCaptchaService;

    @RequestMapping(value =  REGISTER , method = RequestMethod.POST)
    public ResponseEntity<String> register(HttpServletRequest request) {

        // used the recaptcha process
        // this.iCaptchaService.processResponse(request.getParameter("g-recaptcha-response"));
        return new ResponseEntity<String>(String.format(returnString, "Register"), HttpStatus.OK);
    }

    @RequestMapping(value= LOSTPASSWORD, method=RequestMethod.GET)
    public ResponseEntity<String> forgotPassword(HttpServletRequest request) {

        // used the recaptcha process
        // this.iCaptchaService.processResponse(request.getParameter("g-recaptcha-response"));
        return new ResponseEntity<String>(String.format(returnString, "Forgot-password"), HttpStatus.OK);
    }

    @RequestMapping(value = ACTIVATED , method = RequestMethod.POST)
    public ResponseEntity<String> activated() {
        return new ResponseEntity<String>(String.format(returnString, "Activated"), HttpStatus.OK);
    }

    @RequestMapping(value = RESETPASSWORD , method = RequestMethod.POST)
    public ResponseEntity<String> resetPassword(HttpServletRequest request) {

        // used the recaptcha process
        // this.iCaptchaService.processResponse(request.getParameter("g-recaptcha-response"));
        return new ResponseEntity<String>(String.format(returnString, "Reset-Password"), HttpStatus.OK);
    }

}

