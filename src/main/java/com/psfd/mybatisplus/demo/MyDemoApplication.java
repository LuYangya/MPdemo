package com.psfd.mybatisplus.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.psfd.mybatisplus.demo.dao"})
public class MyDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyDemoApplication.class, args);
    }

}
