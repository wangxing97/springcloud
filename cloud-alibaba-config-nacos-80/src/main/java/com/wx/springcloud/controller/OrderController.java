package com.wx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/26
 */
@RestController
@RefreshScope
public class OrderController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/getinfo")
    public String getInfo(){
        return info;
    }

}
