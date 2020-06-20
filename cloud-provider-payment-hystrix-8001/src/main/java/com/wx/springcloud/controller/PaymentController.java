package com.wx.springcloud.controller;

import com.wx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/hystrix/get/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentService.payment_ok(id);
    }

    @GetMapping("/hystrix/get/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id) throws InterruptedException {
        return paymentService.payment_timeout(id);
    }

    @GetMapping("/hystrix/get/circuit/{id}")
    public String circuit_breaker(@PathVariable("id") Integer id){
        return paymentService.circuitBreaker(id);
    }
}
