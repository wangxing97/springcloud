package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/23
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderMain8801.class, args);
    }
}
