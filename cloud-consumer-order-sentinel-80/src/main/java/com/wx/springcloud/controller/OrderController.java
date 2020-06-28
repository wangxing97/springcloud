package com.wx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wx.springcloud.entity.CommonResult;
import com.wx.springcloud.entity.Payment;
import com.wx.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/28
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.url.paymentUrl}")
    private String paymentUrl;

    // ----------OpenFeign-----------
    @GetMapping("/consumer/getByFeign/{id}")
    public CommonResult getPayByFeign(@PathVariable("id") Long id){
        log.info("**************OpenFeign");
        CommonResult<Payment> result = orderService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }
    // ----------Ribbion-----------
    @GetMapping("/consumer/getByRibbion/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult getByRibbion(@PathVariable("id") Long id){
        log.info("**************Ribbion");
        CommonResult result = restTemplate.getForObject(paymentUrl + "/payment/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }
    //本例是fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }
    //本例是blockHandler
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

}
