package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.Ordered;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderSentinelMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderSentinelMain80.class, args);
    }
}
