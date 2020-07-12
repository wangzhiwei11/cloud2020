package com.wangzw.springcloud.controller;

import com.netflix.discovery.DiscoveryClient;
import com.wangzw.springcloud.entity.Payment;
import com.wangzw.springcloud.service.PaymentService;
import com.wangzw.springcloud.vo.CommonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wangzw
 * @date 2020/4/27 15:55
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/add")
    public CommonVO addPayment(@RequestBody Payment payment){
        String id = UUID.randomUUID().toString();
        payment.setId(id);
        int count = paymentService.addPayment(payment);
        log.info("插入结果: {}",count);
        if(count > 0){
            return new CommonVO(true,"插入成功,serverPort="+serverPort,count);
        }else{
            return new CommonVO(false,"插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonVO getPaymentById(@PathVariable String id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonVO(true,"查询成功,serverPort="+serverPort,payment);
        }else{
            return new CommonVO(true,"查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        return discoveryClient;
    }
}
