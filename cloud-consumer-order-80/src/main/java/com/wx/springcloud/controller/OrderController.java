package com.wx.springcloud.controller;

import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001/payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, CommonResult.class);
    }

    @PostMapping("/payment/create")
    public CommonResult createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }
}
