package com.ballistic.barco.config;

import com.ballistic.barco.component.UserDetailsUtil;
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

            ((DefaultOAuth2AccessToken) oAuth2AccessToken).
                    setAdditionalInformation(getAdditionalInfo(oAuth2Authentication));
            return oAuth2AccessToken;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, Object> getAdditionalInfo(OAuth2Authentication oAuth2Authentication) {

        UserDetailsUtil loginUser = (UserDetailsUtil) oAuth2Authentication.getPrincipal();

        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("authorities", loginUser.getAuthorities());
        additionalInfo.put("username", loginUser.getUsername());
        //additionalInfo.put("password", loginUser.getPassword())
        additionalInfo.put("type", loginUser.getType());
        additionalInfo.put("isEnabled",  loginUser.isEnabled());
        additionalInfo.put("account_Expired", loginUser.isAccountNonExpired());
        additionalInfo.put("account_locked", loginUser.isAccountNonLocked());
        additionalInfo.put("credentials_expired", loginUser.isCredentialsNonExpired());
        additionalInfo.put("device", loginUser.getDevice());

        return additionalInfo;
    }
}
