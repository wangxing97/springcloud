package com.wx.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.wx.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/23
 */
@RestController
public class MessageController {

    @Autowired
    private MessageService service;

    @Value("${server.port}")
    private String port;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        String msg = service.send();
        return "端口：" + port + ",消息发送者发送消息：" + msg;
    }


}
