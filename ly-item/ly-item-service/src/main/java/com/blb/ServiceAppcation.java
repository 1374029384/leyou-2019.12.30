package com.blb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.blb.item.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceAppcation {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAppcation.class,args);
    }
}
