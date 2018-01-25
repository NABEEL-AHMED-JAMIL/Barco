package com.ballistic.barco.controller;

import com.ballistic.barco.assemblers.IAuthorizationAssembler;
import com.ballistic.barco.captcha.service.ICaptchaService;
import com.ballistic.barco.service.authorization.IAuthorizationService;
import com.ballistic.barco.vo.ResetPasswordVo;
import com.ballistic.barco.vo.UserRegistrationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static com.ballistic.barco.util.ContentPathUtill.*;

/**
 * Created by Nabeel on 1/16/2018.
 */

@RestController
@RequestMapping(value = AUTH)
public class AuthorizationController {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationController.class);

    public String returnString = "{\"success\": true,   \"payload\": \"{}!\", " + "}";

    @Autowired
    private IAuthorizationAssembler iAuthorizationAssembler;
    @Autowired
    private IAuthorizationService iAuthorizationService;
    @Autowired
    private ICaptchaService iCaptchaService;
    private static final String RECEPTCHA_RESPONSE = "g-recaptcha-response";


    @RequestMapping(value =  REGISTER , method = RequestMethod.POST)
    public ResponseEntity<String> register(@Valid @RequestBody UserRegistrationVo userRegistrationVo,
                                           HttpServletRequest request) throws UnsupportedEncodingException, URISyntaxException {
        // used the recaptcha process
        log.info("start....register....process....rest..api");
        this.iCaptchaService.processResponse(getRecaptchaResponse(request), getIp(request));
        // process for register ...
        log.info("captcha....success....do...next.....save..process");
        return new ResponseEntity<String>(
                iAuthorizationService.register(
                        iAuthorizationAssembler.toUser(userRegistrationVo)), HttpStatus.OK);
    }

    @RequestMapping(value= LOSTPASSWORD, method=RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@RequestBody String email, HttpServletRequest request) throws UnsupportedEncodingException, URISyntaxException {
        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse(request), getIp(request));
        // this send the email to user for reset the password
        // try to send the template...
        return new ResponseEntity<String>(String.format(returnString, "Forgot-password"), HttpStatus.OK);
    }

    @RequestMapping(value = ACTIVATED , method = RequestMethod.POST)
    public ResponseEntity<String> activated(@PathVariable("activationKey") String activationKey,
                                            @RequestBody String email) {
        return new ResponseEntity<String>(String.format(returnString, "Activated"), HttpStatus.OK);
    }

    @RequestMapping(value = RESETPASSWORD , method = RequestMethod.POST)
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordVo resetPasswordVo,
                                                HttpServletRequest request) throws UnsupportedEncodingException, URISyntaxException {
        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse(request), getIp(request));
        return new ResponseEntity<String>(String.format(returnString, "Reset-Password"), HttpStatus.OK);
    }

    private String getRecaptchaResponse(HttpServletRequest request) { return request.getHeader(RECEPTCHA_RESPONSE); }
    private String getIp(HttpServletRequest request) { return request.getRemoteAddr(); }

}

