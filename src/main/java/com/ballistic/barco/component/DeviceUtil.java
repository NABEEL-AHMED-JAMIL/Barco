package com.ballistic.barco.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Nabeel on 1/17/2018.
 */

@Component
public class DeviceUtil {

    private static final String AUDIENCE_UNKNOWN = "unknown";
    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";

    @Value("${access.token.validity.seconds.web}")
    private Integer token_web;
    @Value("${access.token.validity.seconds.other}")
    private Integer token_other_div;
    @Value("${refresh.token.validity.seconds.web}")
    private Integer refresh_token_web;
    @Value("${refresh.token.validity.seconds.other}")
    private Integer refresh_token_other_div;


    private Integer token;
    private Integer refreshToken;

    @Autowired
    HttpServletRequest httpServletRequest;

    public Device getCurrentDevice(HttpServletRequest httpServletRequest) {
        return DeviceUtils.getCurrentDevice(httpServletRequest);
    }

    public String generateAudience() {

        Device device = getCurrentDevice(httpServletRequest);

        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
//            assignTokens(token_web, refresh_token_web);
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
 //           assignTokens(token_other_div, refresh_token_other_div);
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
  //          assignTokens(token_other_div, refresh_token_other_div);
        }
        return audience;
    }


    private void assignTokens(Integer token, Integer refreshToken) {
        setRefreshToken(refreshToken);
        setToken(token);
    }

    public Integer getToken() { return token; }
    public Integer getRefreshToken() { return refreshToken; }

    private void setToken(Integer token) { this.token = token; }
    private void setRefreshToken(Integer refreshToken) { this.refreshToken = refreshToken; }

}
