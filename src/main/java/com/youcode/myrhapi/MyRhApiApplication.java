package com.youcode.myrhapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyRhApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyRhApiApplication.class, args);
    }
}