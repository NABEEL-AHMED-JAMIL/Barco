package com.ballistic.barco.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nabeel on 1/11/2018.
 */
@RestController
@RequestMapping("/secure")
public class QrCodeController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Secure Hello!";
    }
}
