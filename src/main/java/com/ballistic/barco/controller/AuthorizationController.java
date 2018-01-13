package com.ballistic.barco.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ballistic.barco.util.AuthorizationUtill.*;

/**
 * Created by Nabeel on 1/13/2018.
 */

@RestController(value = AUTH)
public class AuthorizationController {

//     , produces = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value =  REGISTER , method = RequestMethod.POST)
    @ResponseBody
    public String register() {
        return "Register";
    }

    @RequestMapping(value = ACTIVATED , method = RequestMethod.POST)
    @ResponseBody
    public String activated() {
        return "Activated";
    }

    @RequestMapping(value = RESETPASSWORD , method = RequestMethod.POST)
    @ResponseBody
    public String resetPassword() {
        return "Reset-Password";
    }

    @RequestMapping(value = LOSTPASSWORD , method = RequestMethod.POST)
    @ResponseBody
    public String lostPassword() {
        return "Lost-Password";
    }

}
