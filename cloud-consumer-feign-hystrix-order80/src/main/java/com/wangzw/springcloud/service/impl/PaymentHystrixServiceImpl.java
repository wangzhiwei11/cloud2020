package com.wangzw.springcloud.service.impl;

import com.wangzw.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author wangzw
 * @date 2020/7/27 16:41
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(String id) {
        return "CLOUD-PAYMENT-SERVICE paymentInfo_ok 访问失败，请稍后重试。。。。";
    }

    @Override
    public String paymentInfo_timeout(String id) {
        return "CLOUD-PAYMENT-SERVICE paymentInfo_timeout 访问失败，请稍后重试。。。。";
    }
}
