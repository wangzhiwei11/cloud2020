package com.wangzw.springcloud.service;

/**
 * @author wangzw
 * @date 2020/7/27 9:45
 */
public interface PaymentService {

    String paymentInfo_ok(String id);

    String paymentInfo_timeout(String id);

    public String paymentCircuitBreaker(String id);
}
