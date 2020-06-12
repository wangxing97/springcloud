package com.wx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/12
 */
@RestController
@Slf4j
public class PaymentController {

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud run with Consul , UUID: " + UUID.randomUUID().toString();
    }
}
