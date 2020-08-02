package com.wangzw.springcloud.controller;

import com.wangzw.springcloud.entity.Payment;
import com.wangzw.springcloud.vo.CommonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wangzw
 * @date 2020/4/30 16:15
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/add")
    public CommonVO<Payment> addPayment(@RequestBody Payment payment){
        String id = UUID.randomUUID().toString();
        payment.setId(id);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonVO.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonVO<Payment> getPayment(@PathVariable String id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonVO.class);
    }

    @GetMapping("comsumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/",String.class);
    }
}
