package com.wx.springcloud.config;

import com.wx.springcloud.Filter.MyZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/20
 */
@Configuration
public class ZuulConfig {

    @Bean
    public MyZuulFilter getFilter(){
        return new MyZuulFilter();
    }
}
