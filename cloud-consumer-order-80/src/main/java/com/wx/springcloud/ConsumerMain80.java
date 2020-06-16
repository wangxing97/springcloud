package com.wx.springcloud;

import com.wx.springcloud.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-PAYMENT-SERVICE",configuration = MyRule.class)
public class ConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class, args);
    }
}
