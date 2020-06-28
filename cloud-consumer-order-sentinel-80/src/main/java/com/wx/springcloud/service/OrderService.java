package com.wx.springcloud.service;

import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/28
 */
@Component
@FeignClient(value = "cloud-sentinel-payment-provider",fallback = OrderSerivceHandler.class)
public interface OrderService {

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
