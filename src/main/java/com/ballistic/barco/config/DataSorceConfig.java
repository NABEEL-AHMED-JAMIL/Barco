package com.ballistic.barco.config;

import com.ballistic.barco.service.AccountAuthenticatoinProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by Nabeel on 1/17/2018.
 */
@Configuration
public class DataSorceConfig {

    private final Logger log = LoggerFactory.getLogger(DataSorceConfig.class);

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Bean
    @Primary
    //Making this primary to avoid any accidental duplication with another token service instance of the same name
    public DefaultTokenServices tokenServices() {

        log.info("Token.....Service..........");
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    // JDBC token store configuration
    @Bean
    public DataSource dataSource() {
        log.info("dataSource for token....");
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource());
    }

}
