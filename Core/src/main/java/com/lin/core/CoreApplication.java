package com.lin.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lin.core.Mapper")
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class,args);
    }

}
