package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrix80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrix80.class, args);
    }

}
