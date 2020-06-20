package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/20
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulMain9001.class, args);
    }
}
