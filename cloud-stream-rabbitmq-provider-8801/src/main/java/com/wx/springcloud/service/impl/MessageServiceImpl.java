package com.wx.springcloud.service.impl;
import cn.hutool.core.util.IdUtil;
import com.wx.springcloud.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/23
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.randomUUID();
        log.info("*****流水号：" + serial);
        output.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
