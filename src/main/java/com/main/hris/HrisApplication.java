package com.main.hris;

import com.main.hris.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Import({ SecurityConfig.class })
public class HrisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrisApplication.class, args);
    }

}
