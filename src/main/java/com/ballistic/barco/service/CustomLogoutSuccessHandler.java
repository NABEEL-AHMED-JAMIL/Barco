package com.ballistic.barco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Component
public class CustomLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {

    private final Logger log = LoggerFactory.getLogger(CustomLogoutSuccessHandler.class);

    private static final String BEARER_AUTHENTICATION = "Bearer ";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static final String HEADER_AUTHORIZATION = "authorization";

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        // fetch token's from the http-request
        String token = httpServletRequest.getHeader(HEADER_AUTHORIZATION);
        String refreshToken = httpServletRequest.getHeader(REFRESH_TOKEN);
        log.info("User token with barer..... {}", token);
        log.info("User refresh token..... {}", refreshToken);
        // check if not null and start with 'Bearer' and not null refreshToken
        if((token != null && token.startsWith(BEARER_AUTHENTICATION)) && refreshToken != null) {

            // Condition true and spilt to access the token and remove from the token-store
            log.info("token" ,token.split(" ")[1]);
            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[1]);
            OAuth2RefreshToken oAuth2RefreshToken = tokenStore.readRefreshToken(refreshToken);
            if(oAuth2AccessToken != null && oAuth2RefreshToken != null) {
                // remove process after getting the token
                tokenStore.removeAccessToken(oAuth2AccessToken);
                tokenStore.removeRefreshToken(oAuth2RefreshToken);
            }
        }
        // return the 'Response with 'Ok response''
        httpServletResponse.setStatus(HttpServletResponse.SC_OK, "{success:You are logout}");
    }
}
