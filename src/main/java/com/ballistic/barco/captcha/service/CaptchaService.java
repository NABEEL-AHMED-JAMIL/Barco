package com.ballistic.barco.captcha.service;

import com.ballistic.barco.captcha.CaptchaSettings;
import com.ballistic.barco.captcha.GoogleResponse;
import com.ballistic.barco.captcha.exception.ReCaptchaInvalidException;
import com.ballistic.barco.captcha.exception.ReCaptchaUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.regex.Pattern;

/**
 * Created by Nabeel on 1/21/2018.
 */
@Service("captchaService")
public class CaptchaService implements ICaptchaService {

    private final static Logger log = LoggerFactory.getLogger(CaptchaService.class);

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CaptchaSettings captchaSettings;
    @Autowired
    private ReCaptchaAttemptService reCaptchaAttemptService;

    private RestOperations restTemplate;
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");


    @Override
    public void processResponse(String response) throws ReCaptchaInvalidException {

        try {

            if(reCaptchaAttemptService.isBlocked(getClientIP())) {
                throw new ReCaptchaInvalidException("Client exceeded maximum number of failed attempts");
            }
            // check the token....
            if (!responseSanityCheck(response)) {
                throw new ReCaptchaInvalidException("Response contains invalid characters");
            }

            final URI verifyUri = URI.create(getReCaptchaUrl() +
                    String.format("?secret=%s&response=%s&remoteip=%s",getReCaptchaSecret(),response, getClientIP()));
            final GoogleResponse googleResponse = this.restTemplate.getForObject(verifyUri, GoogleResponse.class);

            log.info("Google's response: {} ", googleResponse.toString());

            if (!googleResponse.isSuccess()) {
                if (googleResponse.hasClientError()) {
                    reCaptchaAttemptService.reCaptchaFailed(getClientIP());
                }
                throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
            }
        } catch (RestClientException rce) {
            throw new ReCaptchaUnavailableException("Registration unavailable at this time.  Please try again later.", rce);
        }
        reCaptchaAttemptService.reCaptchaSucceeded(getClientIP());

    }

    private boolean responseSanityCheck(final String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    @Override
    public String getReCaptchaSite() { return captchaSettings.getSite(); }
    @Override
    public String getReCaptchaSecret() { return captchaSettings.getSecret(); }
    @Override
    public String getReCaptchaUrl() { return captchaSettings.getUrl(); }

    private String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) { return request.getRemoteAddr(); }
        return xfHeader.split(",")[0];
    }
}
