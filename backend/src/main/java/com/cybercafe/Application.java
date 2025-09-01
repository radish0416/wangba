package com.cybercafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口。
 */
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