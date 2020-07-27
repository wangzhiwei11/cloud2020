package com.wangzw.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangzw.springcloud.service.PaymentHystrixService;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangzw
 * @date 2020/7/27 11:15
 */
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable String id){
        return paymentHystrixService.paymentInfo_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallBackMethod",commandKey = "paymentInfo_timeout")
    //hystrix熔断器需要配合ribbon链接超时一起使用
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallBackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    //调用全局回调函数
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(@PathVariable String id){
        return paymentHystrixService.paymentInfo_timeout(id);
    }

    public String paymentInfoTimeOutFallBackMethod(String id){
        return "线程："+Thread.currentThread().getName()+"调用服务端超时，请稍后重试。。。"+",paymentInfo_timeoutHandler,id:"+id;
    }

    public String paymentGlobalFallBackMethod(){
        return "线程："+Thread.currentThread().getName()+"使用全局回调超时函数。。。";
    }
}
