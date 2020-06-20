package com.wx.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@Component
public class OrderServiceFallBack implements OrderService {

    @Override
    public String payment_ok(Integer id) {
        return "payment_ok--------FeignClient fallback 通配服务降级~";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "payment_timeout--------FeignClient fallback 通配服务降级~";
    }
}
