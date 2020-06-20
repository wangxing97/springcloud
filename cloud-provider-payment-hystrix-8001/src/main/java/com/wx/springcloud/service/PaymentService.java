package com.wx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.bouncycastle.asn1.x509.Time;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@Service
public class PaymentService {

    public String payment_ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + ", payment_ok , id : " + id + ", success!!!";
    }

    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String payment_timeout(Integer id) throws InterruptedException {
        if(id > 0){
            TimeUnit.SECONDS.sleep(5);
            return "线程池：" + Thread.currentThread().getName() + ", payment_timeout , id : " + id + ", success~~~";
        }else{
            int a = 10/0;
            return "线程池：" + Thread.currentThread().getName() + ", payment_timeout , id : " + id + ", success~~~";
        }
    }

    public String payment_timeoutHandler(Integer id){
        return "服务降级,端口：8001,线程池：" + Thread.currentThread().getName() + ", payment_timeoutHandler , id : " + id + ", fail~~~";
    }
    // 服务熔断
    @HystrixCommand(fallbackMethod = "circuitBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String circuitBreaker(Integer id){
        if(id < 0){
            throw  new RuntimeException("id不能为负数~");
        }else{
            return "服务调用，" + Thread.currentThread().getName() + "，流水号：" + IdUtil.randomUUID();
        }
    }

    public String circuitBreakerHandler(Integer id){
        return "服务暂不可用~，请稍后再试~";
    }
}
