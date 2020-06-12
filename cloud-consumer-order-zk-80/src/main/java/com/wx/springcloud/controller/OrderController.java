package com.wx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/11
 */
@RestController
public class OrderController {

    public static final String PAYMENT_URI = "http://provider-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentZk(){
        String result = restTemplate.getForObject(PAYMENT_URI + "/payment/zk", String.class);
        return result;
    }
}
