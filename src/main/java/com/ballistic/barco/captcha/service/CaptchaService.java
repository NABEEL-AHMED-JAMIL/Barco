package com.ballistic.barco.captcha.service;

import com.ballistic.barco.captcha.CaptchaSettings;
import com.ballistic.barco.captcha.GoogleResponse;
import com.ballistic.barco.captcha.exception.ReCaptchaInvalidException;
import com.ballistic.barco.captcha.exception.ReCaptchaUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Pattern;

/**
 * Created by Nabeel on 1/21/2018.
 */
@Service("captchaService")
public class CaptchaService implements ICaptchaService {

    private final static Logger log = LoggerFactory.getLogger(CaptchaService.class);

    @Autowired
    private CaptchaSettings captchaSettings;
    @Autowired
    private ReCaptchaAttemptService reCaptchaAttemptService;

    private static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");


    @Override
    public void processResponse(String response, String ip)  {

        log.info("process....Re-Captcha....Check.....");
        try {
            // check ip blocked or not
            isBlockedIo(ip);
            // check the token.... valid character or not
            checkValidCharacter(response);

            MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
            form.add("secret", getReCaptchaSecret());
            form.add("response", response);
            form.add("remoteip", ip);

            GoogleResponse googleResponse = getRestTemplate().postForObject(getReCaptchaUrl(), form ,GoogleResponse.class);
            log.info("Google's response: {} ", googleResponse.toString());

            if (!googleResponse.isSuccess()) {
                if (googleResponse.hasClientError()) {
                    reCaptchaAttemptService.reCaptchaFailed(ip);
                }
                throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
            }

        } catch (RestClientException rce) {
            throw new ReCaptchaUnavailableException("Registration unavailable at this time.  Please try again later.", rce);
        }
        reCaptchaAttemptService.reCaptchaSucceeded(ip);
    }

    private boolean responseSanityCheck(final String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    private void isBlockedIo(String ip) {

        if(reCaptchaAttemptService.isBlocked(ip)) {
            throw new ReCaptchaInvalidException("Client exceeded maximum number of failed attempts");
        }
    }

    private void checkValidCharacter(String response) {

        if (!responseSanityCheck(response)) {
            throw new ReCaptchaInvalidException("Response contains invalid characters");
        }
    }


    @Override
    public String getReCaptchaSite() { return captchaSettings.getSite(); }
    @Override
    public String getReCaptchaSecret() { return captchaSettings.getSecret(); }
    @Override
    public String getReCaptchaUrl() { return captchaSettings.getUrl(); }

    private RestTemplate getRestTemplate(){ return  new RestTemplate(); }

}
