package com.wangzw.springcloud.controller;

import com.wangzw.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangzw
 * @date: 2020-07-26 15:55
 **/
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable String id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable String id){
        return paymentService.paymentInfo_timeout(id);
    }

    //===服务熔断
    @GetMapping("/payment/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable String id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
