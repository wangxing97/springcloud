package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain80{
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain80.class, args);
    }
}
