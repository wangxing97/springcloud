package com.wx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/26
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-payment-service-url}")
    private String serviceUrl;

    @GetMapping("/nacos/consumer/info")
    public String pay(){
        return restTemplate.getForObject(serviceUrl + "/nacos/payment/info", String.class);
    }

}
