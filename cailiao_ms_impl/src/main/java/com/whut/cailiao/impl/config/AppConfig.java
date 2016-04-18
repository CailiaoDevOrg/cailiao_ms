package com.whut.cailiao.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by niuyang on 16/1/31.
 */
@Configuration
public class AppConfig {

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    public UTF8StringHttpMessageConverter messageConverters() {
        UTF8StringHttpMessageConverter converter = new UTF8StringHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("text", "plain", Charset.forName("UTF-8")),
                new MediaType("text", "html", Charset.forName("UTF-8"))));
        return converter;
    }

}
