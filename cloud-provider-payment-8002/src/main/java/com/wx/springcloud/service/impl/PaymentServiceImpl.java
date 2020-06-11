package com.wx.springcloud.service.impl;

import com.wx.springcloud.dao.PaymentDao;
import com.wx.springcloud.entity.Payment;
import com.wx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
