package com.wx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/22
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String msg;

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return "Port:" + port + "  ," + msg;
    }
}
