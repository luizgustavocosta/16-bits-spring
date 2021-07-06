package com.costa.luiz.spring.helloworld;

import com.costa.luiz.spring.resource.HelloWorldController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = HelloWorldController.class)
public class AppMainConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppMainConfig.class, args);
    }
}
