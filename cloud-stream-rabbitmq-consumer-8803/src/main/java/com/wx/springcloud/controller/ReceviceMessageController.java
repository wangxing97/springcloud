package com.wx.springcloud.controller;

import com.wx.springcloud.stream.MyStream;
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
@EnableBinding(MyStream.class)
@Slf4j
public class ReceviceMessageController {

    @Value("${server.port}")
    private String port;

    @StreamListener(MyStream.myInput)
    public void input(Message<String> msg){
        log.info("消费者8803，端口：" + port + "，收到消息：" + msg.getPayload());
    }
}
