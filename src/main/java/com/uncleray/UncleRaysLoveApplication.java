package com.uncleray;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uncleray.web.dao.mapper")
public class UncleRaysLoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(UncleRaysLoveApplication.class, args);
    }

}
