package com.whut.cailiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by niuyang on 16/1/25.
 */

/**
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@SpringBootApplication
public class MSApplication {

    public static void main(String[] args) {
        SpringApplication.run(MSApplication.class, args);
    }

}
