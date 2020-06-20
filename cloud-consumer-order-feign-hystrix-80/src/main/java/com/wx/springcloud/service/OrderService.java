package com.wx.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@FeignClient(name = "PROVIDER-PAYMENT-HYSTRIX-SERVICE",fallback = OrderServiceFallBack.class)
@Component
public interface OrderService {

    @GetMapping("/payment/hystrix/get/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/get/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
