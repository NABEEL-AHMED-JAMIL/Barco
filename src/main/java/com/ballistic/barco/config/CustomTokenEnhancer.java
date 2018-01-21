package com.ballistic.barco.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nabeel on 1/17/2018.
 */
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        try {
            User loginUser = (User) oAuth2Authentication.getPrincipal();
            final Map<String, Object> additionalInfo = new HashMap<>();
            additionalInfo.put("authorities", loginUser.getAuthorities());
            additionalInfo.put("username", loginUser.getUsername());
            additionalInfo.put("isEnabled", loginUser.isEnabled());
            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
            return oAuth2AccessToken;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

