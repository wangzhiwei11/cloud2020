package com.wangzw.springcloud.service;

import com.wangzw.springcloud.entity.Payment;

/**
 * @author wangzw
 * @date 2020/4/27 15:48
 */
public interface PaymentService {

    int addPayment(Payment payment);

    Payment getPaymentById(String id);
}
