package com.wx.springcloud.service;

import com.wx.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@Component
@FeignClient(value = "PROVIDER-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/get/timeout")
    public String paymentFeignTimeout();
}
