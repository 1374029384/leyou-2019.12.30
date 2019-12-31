package com.blb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceAppcation {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAppcation.class,args);
    }
}
