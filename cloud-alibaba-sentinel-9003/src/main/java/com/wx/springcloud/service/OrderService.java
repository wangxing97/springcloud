package com.wx.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wx.springcloud.entity.CommonResult;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/27
 */
@Service
public class OrderService {

    @SentinelResource(value = "getOrder",blockHandler = "handlerException")
    public CommonResult getOrder(){
        return new CommonResult(200, "getOrder Successful");
    }

    public CommonResult handleException(BlockException ex) {
        return new CommonResult(400,
                ex.getClass().getCanonicalName() + "\t服务不可用");
    }
}
