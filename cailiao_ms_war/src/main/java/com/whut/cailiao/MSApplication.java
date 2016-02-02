package com.whut.cailiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
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
public class MSApplication {

    public static void main(String[] args) {
        SpringApplication.run(MSApplication.class, args);
    }

}
