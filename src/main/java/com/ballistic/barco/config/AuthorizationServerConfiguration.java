package com.ballistic.barco.config;

import com.ballistic.barco.repository.AuthorityRepository;
import com.ballistic.barco.service.Authorities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by Nabeel on 1/11/2018.
 */
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
    @Value("${access.token.validity.seconds.web}")
    private Integer token_web;
    @Value("${access.token.validity.seconds.other}")
    private Integer token_other_div;
    @Value("${refresh.token.validity.seconds.web}")
    private Integer refresh_token_web;
    @Value("${refresh.token.validity.seconds.other}")
    private Integer regresh_token_other_div;


    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // @formatter:off
        clients.jdbc(dataSource).
                withClient(clientId).
                resourceIds(resourceIds).
                scopes(scopeRead,scopeWrite).
                authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name(), Authorities.ROLE_ANONYMOUS.name()).
                authorizedGrantTypes(grantTypePassword, grantTypeClientCredentials, grantTypeRefreshToken).
                secret(clientSecret).
                accessTokenValiditySeconds(180*2).
                refreshTokenValiditySeconds(1800*2);
        // @formatter:on
    }



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // @formatter:off
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(new CustomTokenEnhancer()));
        endpoints.tokenStore(tokenStore).
                tokenEnhancer(tokenEnhancerChain).
                authenticationManager(authenticationManager);
        // @formatter:on
    }

}