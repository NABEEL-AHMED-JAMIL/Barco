package com.ballistic.barco.config;

import com.ballistic.barco.service.CustomAuthenticationEntryPoint;
import com.ballistic.barco.service.CustomLogoutSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
    private ResourceServerTokenServices tokenServices;
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic().realmName(securityRealm).and().
                csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize")).disable().
                exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).
                and().
                logout().logoutUrl("/oauth/logout").logoutSuccessHandler(customLogoutSuccessHandler).
                and().
                // access after the login user
                authorizeRequests().antMatchers("/secure/**").authenticated().
                and().
                headers().frameOptions().disable();
    }


}
