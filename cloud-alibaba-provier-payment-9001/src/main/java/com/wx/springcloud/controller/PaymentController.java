package com.wx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/26
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/payment/info")
    public String pay(){
        return "Nacos Server Payment Port ：" + serverPort + "，流水号：" + UUID.randomUUID().toString();
    }

}
