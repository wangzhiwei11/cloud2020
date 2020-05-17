package com.wangzw.springcloud.service.impl;

import com.wangzw.springcloud.dao.PaymentDao;
import com.wangzw.springcloud.entity.Payment;
import com.wangzw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangzw
 * @date 2020/4/27 15:50
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentDao.getPaymentById(id);
    }
}
