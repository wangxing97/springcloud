package com.wx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wx.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@DefaultProperties(defaultFallback = "payment_Global_FallBack")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/hystrix/get/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return orderService.payment_ok(id);
    }

    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    @GetMapping("/consumer/hystrix/get/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return  orderService.payment_timeout(id);
    }

    public String payment_timeoutHandler(Integer id){
        return "服务降级,端口：80,线程池：" + Thread.currentThread().getName() + ", payment_timeoutHandler , id : " + id + ", fail~~~";
    }

    @HystrixCommand
    @GetMapping("/consumer/hystrix/get/global/{id}")
    public String payment_global(){
        int a = 10/0;
        return  orderService.payment_timeout(1);
    }

    public String payment_Global_FallBack(){
        return "服务降级,端口：80,全局FallBack~";
    }
}
