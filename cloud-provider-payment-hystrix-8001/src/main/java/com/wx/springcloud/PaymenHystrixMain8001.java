package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymenHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymenHystrixMain8001.class, args);
    }
}
