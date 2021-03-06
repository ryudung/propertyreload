package com.example.propertyreload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Develop In Action.
 * <p>
 * create by: ryugwanghyen
 * create Time : 2017-10-13
 */
@Configuration
@PropertySource(value = "classpath:/properties/common.properties")
public class EnvironmentConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}