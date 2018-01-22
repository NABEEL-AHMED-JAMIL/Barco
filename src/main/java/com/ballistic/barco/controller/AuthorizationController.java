package com.ballistic.barco.controller;

import com.ballistic.barco.assemblers.IAuthorizationAssembler;
import com.ballistic.barco.captcha.service.ICaptchaService;
import com.ballistic.barco.service.authorization.IAuthorizationService;
import com.ballistic.barco.vo.ResetPasswordVo;
import com.ballistic.barco.vo.UserRegistrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.ballistic.barco.util.ContentPathUtill.*;

/**
 * Created by Nabeel on 1/16/2018.
 */

@RestController
@RequestMapping(value = AUTH)
public class AuthorizationController {

    public String returnString = "{\"success\": true,   \"payload\": \"{}!\", " + "}";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private IAuthorizationAssembler iAuthorizationAssembler;
    @Autowired
    private IAuthorizationService iAuthorizationService;
    @Autowired
    private ICaptchaService iCaptchaService;
    private static final String RECEPTCHA_RESPONSE = "g-recaptcha-response";


    @RequestMapping(value =  REGISTER , method = RequestMethod.POST)
    public ResponseEntity<String> register(@Valid @RequestBody UserRegistrationVo userRegistrationVo) throws Exception {
        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse());
        // process for register ...
        return new ResponseEntity<String>(
                iAuthorizationService.register(
                        iAuthorizationAssembler.toComment(userRegistrationVo)), HttpStatus.OK);
    }

    @RequestMapping(value= LOSTPASSWORD, method=RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {

        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse());
        return new ResponseEntity<String>(String.format(returnString, "Forgot-password"), HttpStatus.OK);
    }

    @RequestMapping(value = ACTIVATED , method = RequestMethod.POST)
    public ResponseEntity<String> activated(@PathVariable("activationKey") Long activationKey, @RequestBody String email) {
        return new ResponseEntity<String>(String.format(returnString, "Activated"), HttpStatus.OK);
    }

    @RequestMapping(value = RESETPASSWORD , method = RequestMethod.POST)
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordVo resetPasswordVo) {
        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse());
        return new ResponseEntity<String>(String.format(returnString, "Reset-Password"), HttpStatus.OK);
    }

    private String getRecaptchaResponse() { return request.getParameter(RECEPTCHA_RESPONSE); }

}

