package com.example.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplustest.store.mapper")
public class MybatisplustestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplustestApplication.class, args);
    }

}
