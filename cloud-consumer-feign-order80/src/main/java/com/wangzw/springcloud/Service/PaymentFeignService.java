package com.wangzw.springcloud.Service;

import com.wangzw.springcloud.entity.Payment;
import com.wangzw.springcloud.vo.CommonVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //使用Feign封装接口，@PathVariable注解后接收参数必须加(value="id")
    @GetMapping(value = "/payment/get/{id}")
    public CommonVO<Payment> getPaymentById(@PathVariable(value="id") String id);
}
