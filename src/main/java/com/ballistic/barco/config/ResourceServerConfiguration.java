package com.ballistic.barco.config;

import com.ballistic.barco.service.CustomAuthenticationEntryPoint;
import com.ballistic.barco.service.CustomLogoutSuccessHandler;
import com.ballistic.barco.util.BuiltInUtill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.ballistic.barco.util.ContentPathUtill.*;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;
    @Value("${security.security-realm}")
    private String securityRealm;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // @formatter:off
        resources.resourceId(resourceIds).tokenStore(tokenStore);
        // @formatter:on
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.httpBasic().realmName(securityRealm).and().exceptionHandling().
                authenticationEntryPoint(customAuthenticationEntryPoint).and().logout().logoutUrl(LOGOUT).
                logoutSuccessHandler(customLogoutSuccessHandler);
        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher(AUTHORIZE)).
                disable().headers().frameOptions().disable().and().authorizeRequests().
                antMatchers("/api"+AUTH+REGISTER, "/api"+AUTH+ACTIVATED, "/api"+AUTH+RESETPASSWORD,"/api"+AUTH+LOSTPASSWORD).
                permitAll().
                antMatchers(QR_SECURE).authenticated();
        // @formatter:on
    }

    @Bean
    public BuiltInUtill builtInUtill() { return new BuiltInUtill(); }
}
