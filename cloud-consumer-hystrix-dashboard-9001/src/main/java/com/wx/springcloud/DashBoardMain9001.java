package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/20
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardMain9001.class, args);
    }
}
