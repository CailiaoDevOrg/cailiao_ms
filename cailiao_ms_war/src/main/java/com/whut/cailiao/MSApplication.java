package com.whut.cailiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by niuyang on 16/1/25.
 */

/**
 * <tx:annotation-driven />
 */
/**
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
// @ImportResource("classpath:server-provider.xml")
public class MSApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MSApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MSApplication.class, args);
    }
}
