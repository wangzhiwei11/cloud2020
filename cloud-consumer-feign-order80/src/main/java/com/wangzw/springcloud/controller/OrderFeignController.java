package com.wangzw.springcloud.controller;

import com.wangzw.springcloud.service.PaymentFeignService;
import com.wangzw.springcloud.entity.Payment;
import com.wangzw.springcloud.vo.CommonVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangzw
 * @date: 2020-07-25 13:13
 **/
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonVO<Payment> getPaymentById(@PathVariable String id){
        return paymentFeignService.getPaymentById(id);
    }
}
