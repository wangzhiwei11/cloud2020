package com.wangzw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangzw
 * @date 2020/8/3 14:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain90.class,args);
    }
}
