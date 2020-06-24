package com.wx.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.discovery.converters.Auto;
import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import com.wx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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
    public CommonResult getPaymentById(@PathVariable("id") Long id, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        log.info("*****Token：" + token);
        Payment pay = paymentService.getPaymentById(id);
        log.info("*****查询结果:"+pay);
        if(!StringUtils.isEmpty(pay)){
            return new CommonResult(200, "获取数据成功,端口:" + serverPort,pay);
        }else{
            return new CommonResult(444, "获取数据失败");
        }
    }

    @GetMapping("/get/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }

    @GetMapping("/get/discover")
    public Object getDiscover(){
        //获取注册中心中所有的服务
        List<String> services = discoveryClient.getServices();
        for (String service: services) {
            log.info("element****:" + service);
        }
        //获取某个服务下的所有服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            log.info("instance****:" + instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "payment - zipkin order : " + IdUtil.randomUUID();
    }
}
