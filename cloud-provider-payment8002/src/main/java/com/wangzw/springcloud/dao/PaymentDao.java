package com.wangzw.springcloud.dao;

import com.wangzw.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangzw
 * @date 2020/4/27 15:17
 */
@Mapper
public interface PaymentDao {

    int addPayment(Payment payment);

    Payment getPaymentById(String id);
}
