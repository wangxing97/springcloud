package com.wx.springcloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/23
 */
public interface MyStream {

    String myInput = "myInput";

    @Input(MyStream.myInput)
    SubscribableChannel input();
}
