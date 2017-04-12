package com.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
public class RootController {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(RootController.class, args);
    }
}
