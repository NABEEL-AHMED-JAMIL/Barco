package com.ballistic.barco.controller;

import com.ballistic.barco.assemblers.IAuthorizationAssembler;
import com.ballistic.barco.captcha.service.ICaptchaService;
import com.ballistic.barco.domain.auth.User;
import com.ballistic.barco.service.Encryption;
import com.ballistic.barco.service.authorization.IAuthorizationService;
import com.ballistic.barco.vo.ResetPasswordVo;
import com.ballistic.barco.vo.UserRegistrationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
    @Autowired
    private HttpServletRequest request;

    private static final String RECEPTCHA_RESPONSE = "g-recaptcha-response";

    
    // USE object and further convert to the => vo then do process
    @RequestMapping(value =  REGISTER , method = RequestMethod.POST)
    public ResponseEntity<String> register(@Valid @RequestBody UserRegistrationVo userRegistrationVo) {
        
    	
    	if(UserType.EMPLOYEE != null) {
    		// for employee
    		
    	} else if (UserType.CUSTOMER != null) {
    		// for customer
    		
    	} else if (UserType.SHIPPER != null) {
    		// for shipper
    
    	} else if(UserType.SUPPLIER != null) {
    		// for supplier	
    		
    	} else {
    		// no process work 
    	}
    	
    	// used the recaptcha process
        log.info("start....register....process....rest..api");
        this.iCaptchaService.processResponse(getRecaptchaResponse(), getIp());
        // process for register ...
        log.info("captcha....success....do...next.....save..process");
        return new ResponseEntity<String>(
                iAuthorizationService.register(
                        iAuthorizationAssembler.toUser(userRegistrationVo)), HttpStatus.OK);
    }

    @RequestMapping(value= LOSTPASSWORD, method=RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {
        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse(), getIp());
        // this send the email to user for reset the password
        // try to send the template...
        return new ResponseEntity<String>(String.format(returnString, "Forgot-password"), HttpStatus.OK);
    }

    @RequestMapping(value = ACTIVATED , method = RequestMethod.POST)
    public ResponseEntity<String> activated(@PathVariable("activationKey") String activationKey, @RequestBody String email) {
        if(verifyKey(activationKey, email)) {
            // do futher process
        }
        return new ResponseEntity<String>(String.format(returnString, "Activated"), HttpStatus.OK);
    }

    @RequestMapping(value = RESETPASSWORD , method = RequestMethod.POST)
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordVo resetPasswordVo) {
        // used the recaptcha process
        this.iCaptchaService.processResponse(getRecaptchaResponse(), getIp());

        return new ResponseEntity<String>(String.format(returnString, "Reset-Password"), HttpStatus.OK);
    }


    private String getRecaptchaResponse() { return request.getHeader(RECEPTCHA_RESPONSE); }
    private String getIp() { return request.getRemoteAddr(); }
    private Boolean verifyKey(final String key, final String email) {
        Boolean result = false;
        try {
            result = Encryption.decryPtion(key).equals(email);
        } catch (IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException
                | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    private enum UserType {
    	CUSTOMER, EMPLOYEE, SHIPPER, SUPPLIER
    }


}

