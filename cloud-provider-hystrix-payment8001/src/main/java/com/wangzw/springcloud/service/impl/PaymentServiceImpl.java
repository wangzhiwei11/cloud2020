package com.wangzw.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangzw.springcloud.service.PaymentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzw
 * @date 2020/7/27 9:46
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Override
    public String paymentInfo_ok(String id) {
        return "线程："+Thread.currentThread().getName()+",paymentInfo_ok,id:"+id;
    }

    //===服务降级====
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(String id) {
        System.out.println("服务端8001被调用");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程："+Thread.currentThread().getName()+",paymentInfo_timeout,id:"+id;
    }

    public String paymentInfo_timeoutHandler(String id){
        return "线程："+Thread.currentThread().getName()+"调用超时。。。"+",paymentInfo_timeoutHandler,id:"+id;
    }

    //===服务熔断===
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBackMethod",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(String id){
        if(Integer.valueOf(id)<0){
            throw new RuntimeException("id不能为空。。。");
        }
        return "线程："+Thread.currentThread().getName()+",paymentCircuitBreaker,id:"+id;
    }

    public String paymentCircuitBreakerFallBackMethod(String id){
        return "线程："+Thread.currentThread().getName()+",paymentCircuitBreaker服务熔断回调函数。。。";
    }
}
