package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacosMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosMain80.class, args);
    }
}
