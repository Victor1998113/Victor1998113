package com.victor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.victor.mapper")
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
