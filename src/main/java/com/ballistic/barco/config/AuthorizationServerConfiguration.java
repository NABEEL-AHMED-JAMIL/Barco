package com.ballistic.barco.config;

import com.ballistic.barco.service.Authorities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

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

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    @Autowired
    private DataSource dataSource;
    @Bean
    public TokenStore tokenStore() { return new JdbcTokenStore(dataSource); }

    @Bean
    @Primary
    //Making this primary to avoid any accidental duplication with another token service instance of the same name
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource).
                withClient(clientId).
                scopes(scopeRead,scopeWrite).
                authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name(),Authorities.ROLE_ANONYMOUS.name()).
                authorizedGrantTypes(grantTypePassword, grantTypeClientCredentials, grantTypeRefreshToken).
                secret(clientSecret).
                accessTokenValiditySeconds(180).
                refreshTokenValiditySeconds(180*2);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
    }


}
