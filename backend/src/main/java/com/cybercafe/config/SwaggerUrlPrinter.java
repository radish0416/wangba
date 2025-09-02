package com.cybercafe.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class SwaggerUrlPrinter implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String port = "8090"; // 根据您的实际端口调整
            
            System.out.println("----------------------------------------------------");
            System.out.println("Swagger UI 地址: http://localhost:" + port + "/swagger-ui.html");
            System.out.println("API Docs 地址: http://localhost:" + port + "/v3/api-docs");
            System.out.println("----------------------------------------------------");
        } catch (UnknownHostException e) {
            System.out.println("无法获取本地地址");
        }
    }
}
