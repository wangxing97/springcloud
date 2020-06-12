package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsul80 {
    //因为Consul部署在阿里云服务器上，服务需要调用本机的actuator/health，无法访问到所以有红X，以后在解决
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsul80.class, args);
    }
}
