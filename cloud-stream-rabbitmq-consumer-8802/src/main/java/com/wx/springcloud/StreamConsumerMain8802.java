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
public class StreamConsumerMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8802.class, args);
    }

}
