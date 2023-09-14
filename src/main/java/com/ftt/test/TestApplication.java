package com.ftt.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.ftt.test.dao")
@EnableSwagger2
@ComponentScan(basePackages = {"com.ftt.test.config","com.ftt.test.controller","com.ftt.test"})
public class TestApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(TestApplication.class, args);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
