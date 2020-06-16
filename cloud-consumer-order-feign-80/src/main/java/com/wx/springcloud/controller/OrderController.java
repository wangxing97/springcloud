package com.wx.springcloud.controller;

import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.service.PaymentFeignService;
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
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private PaymentFeignService service;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return service.getPaymentById(id);
    }

    @GetMapping("/payment/get/timeout")
    public String paymentFeignTimeout(){
        return service.paymentFeignTimeout();
    }
}
