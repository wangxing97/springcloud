package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentSentinelMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSentinelMain9004.class, args);
    }
}
