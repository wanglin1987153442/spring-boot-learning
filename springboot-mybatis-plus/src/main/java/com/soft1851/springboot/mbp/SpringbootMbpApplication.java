package com.soft1851.springboot.mbp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.soft1851.springboot.mbp.mapper")
public class SpringbootMbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMbpApplication.class, args);
    }

}
