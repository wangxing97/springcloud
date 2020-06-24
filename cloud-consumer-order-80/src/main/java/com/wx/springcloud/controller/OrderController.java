package com.wx.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import com.wx.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001/payment"; //单机版

    public static final String PAYMENT_URL = "http://PROVIDER-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private MyLB myLB;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Long id) {
        //手写轮询
        //List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT-SERVICE");
        //ServiceInstance instance = myLB.instances(instances);
        //URI uri = instance.getUri();
        //return restTemplate.getForObject(uri + "/payment/get/" + id, CommonResult.class);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public ResponseEntity<CommonResult> getPaymentByID1(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info("****entity.getStatusCode():" + entity.getStatusCode());
        log.info("****entity.getStatusCodeValue():" + entity.getStatusCodeValue());
        log.info("****entity.getBody():" + entity.getBody());
        log.info("****entity.getHeaders():" + entity.getHeaders());
        return entity;
    }

    @PostMapping("/payment/create/postForEntity")
    public CommonResult<Payment> getPaymentByID2(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return entity.getBody();
    }

    @PostMapping("/payment/create")
    public CommonResult createPayment(Payment payment) {
        log.info("****:" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }
}
