package com.wx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/23
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceviceMessageController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg){
        log.info("消费者8802，端口：" + port + "，收到消息：" + msg.getPayload());
    }
}
