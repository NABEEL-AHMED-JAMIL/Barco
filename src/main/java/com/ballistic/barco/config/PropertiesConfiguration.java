package com.ballistic.barco.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nabeel on 13/2/2018.
 */
@Configuration
public class PropertiesConfiguration {

    private final Logger log = LoggerFactory.getLogger(PropertiesConfiguration.class);

    private final String[] propertiesFiles = { "application.properties",
            "captcha.properties", "logs.properties",
            "rds.properties", "security.properties" };

    @Bean
    public PropertyPlaceholderConfigurer properties() {

        log.info("Start Properties.....File...Read...Process");

        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        final List<Resource> resourceLst = new ArrayList<Resource>();
        for (String propertiesFile: propertiesFiles) {
            log.info("Start Properties.....File...Read..." + propertiesFile);
            resourceLst.add(new ClassPathResource(propertiesFile));
        }
        ppc.setLocations(resourceLst.toArray(new Resource[]{}));

        log.info("End Properties.....File...Read...Process");

        return ppc;
    }

}
