package com.example.apptest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.example.**.mapper")
public class AppTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTestApplication.class, args);
    }

}
