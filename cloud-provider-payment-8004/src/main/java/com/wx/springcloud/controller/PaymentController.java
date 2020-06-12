package com.wx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/11
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentZk(){
        return "SpringCloud with Zookeeper :" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
