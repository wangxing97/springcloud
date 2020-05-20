package com.wx.springcloud.service;

import com.wx.springcloud.entity.Payment;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
public interface PaymentService {

    int createPayment(Payment payment);
    Payment getPaymentById(Long id);

}
