package com.wx.springcloud.service;

import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/28
 */
@Component
public class OrderSerivceHandler implements  OrderService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
