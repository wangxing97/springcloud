package com.wx.springcloud.controller;

import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import com.wx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        log.info("*****插入结果:"+result);
        if(result > 0){
            return new CommonResult(200, "插入数据成功~", result);
        }else{
            return new CommonResult(444, "插入数据失败~");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment pay = paymentService.getPaymentById(id);
        log.info("*****查询结果:"+pay);
        if(!StringUtils.isEmpty(pay)){
            return new CommonResult(200, "获取数据成功,端口:" + serverPort,pay);
        }else{
            return new CommonResult(444, "获取数据失败");
        }
    }
}
