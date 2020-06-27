package com.wx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.service.OrderService;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/26
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/HelloA")
    public String getA()
    {
        return "------HelloA------";
    }

    @GetMapping("/HelloB")
    public String getB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"------HelloB------");
        //try {
        //    Thread.sleep(800);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        return "------HelloB------";
    }
    @GetMapping("/HelloC")
    public String getC()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName()+"\t"+"------HelloC------");
        return "------HelloC------";
    }
    @GetMapping("/HelloD")
    public String getD()
    {
        int a = 10/0;
        log.info(Thread.currentThread().getName()+"\t"+"------HelloD------");
        return "------HelloD------";
    }
    @GetMapping("/HelloE")
    @SentinelResource(value = "helloE",blockHandler = "hostKeyHandler")
    public String getE(@RequestParam(value = "a",required = false)String a
                      ,@RequestParam(value = "b",required = false)String b)
    {
        return "------HelloE------";
    }
    public String hostKeyHandler(String a, String b, BlockException ex){
        return ex.getRule().getResource()+"，服务正忙，稍后再试~";
    }
    /*@Resource
    private OrderService orderService;

    @GetMapping("/HelloA")
    public CommonResult getA()
    {
        return orderService.getOrder();
    }

    @GetMapping("/HelloB")
    public CommonResult getB()
    {
        return orderService.getOrder();
    }*/

}
