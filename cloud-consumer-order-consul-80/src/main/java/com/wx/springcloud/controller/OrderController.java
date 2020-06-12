package com.wx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/12
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    private static final String PAYMENT_URI = "http://provider-payment-8006";

    @GetMapping("/consumer/payment/consul")
    public String paymentOrder(){
        String msg = restTemplate.getForObject(PAYMENT_URI + "/payment/consul", String.class);
        return msg;
    }
}
