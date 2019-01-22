package com.hyh.shoppingmallmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyh.shoppingmallmanage.mapper")
public class ShoppingmallManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingmallManageApplication.class, args);
    }
}
