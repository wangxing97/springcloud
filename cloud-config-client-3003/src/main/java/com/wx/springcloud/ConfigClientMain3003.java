package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/22
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3003 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3003.class, args);
    }
}
