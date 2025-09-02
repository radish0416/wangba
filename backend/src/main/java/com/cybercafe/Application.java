package com.cybercafe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 应用启动入口。
 */
@MapperScan("com.cybercafe.repository.mapper") // 添加这行
@SpringBootApplication
public class Application {
    /**
     * 启动方法。
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}