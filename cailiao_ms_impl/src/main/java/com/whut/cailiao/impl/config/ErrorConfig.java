package com.whut.cailiao.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * Created by gammaniu on 16/4/20.
 */
@Configuration
public class ErrorConfig {
    
    @Bean
    public SimpleMappingExceptionResolver handlerExceptionResolver() {
        SimpleMappingExceptionResolver handlerExceptionResolver = new SimpleMappingExceptionResolver();
        Properties exceptionMappings = new Properties();
        exceptionMappings.setProperty("java.lang.Throwable", "error/500");
        handlerExceptionResolver.setExceptionMappings(exceptionMappings);
        return handlerExceptionResolver;
    }
}
