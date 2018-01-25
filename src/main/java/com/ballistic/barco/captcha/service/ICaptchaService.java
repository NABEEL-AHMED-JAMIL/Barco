package com.ballistic.barco.captcha.service;

import com.ballistic.barco.captcha.exception.ReCaptchaInvalidException;

import java.net.URISyntaxException;

/**
 * Created by Nabeel on 1/21/2018.
 */
public interface ICaptchaService {

    void processResponse(final String response, String ip) throws ReCaptchaInvalidException, URISyntaxException;
    String getReCaptchaSite();
    String getReCaptchaSecret();
    String getReCaptchaUrl();
}