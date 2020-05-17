package com.wangzw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangzw
 * @date 2020/4/30 16:20
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//开启restTemplate负责均衡功能，自动调用微服务提供者  默认为轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
