package com.ballistic.barco.config;

import com.ballistic.barco.service.Authorities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import java.util.Arrays;

/**
 * Created by Nabeel on 1/11/2018.
 */
// token refresh need to acces
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(AuthorizationServerConfiguration.class);

    @Value("${security.jwt.client-id}")
    private String clientId;
    @Value("${security.jwt.client-secret}")
    private String clientSecret;
    @Value("${security.jwt.grant-type-password}")
    private String grantTypePassword;
    @Value("${security.jwt.grant-type-refresh_token}")
    private String grantTypeRefreshToken;
    @Value("${security.jwt.grant-type-client-credentials}")
    private String grantTypeClientCredentials;
    @Value("${security.jwt.scope-read}")
    private String scopeRead;
    @Value("${security.jwt.scope-write}")
    private String scopeWrite = "write";
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId).
                scopes(scopeRead,scopeWrite).
                authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name(),Authorities.ROLE_ANONYMOUS.name()).
                authorizedGrantTypes(grantTypePassword, grantTypeClientCredentials, grantTypeRefreshToken).
                secret(clientSecret).
                accessTokenValiditySeconds(180).
                refreshTokenValiditySeconds(180*2);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        endpoints.tokenStore(tokenStore)
                .accessTokenConverter(accessTokenConverter)
                .tokenEnhancer(enhancerChain)
                .authenticationManager(authenticationManager);
    }
}
