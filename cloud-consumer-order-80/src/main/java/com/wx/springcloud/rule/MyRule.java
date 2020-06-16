package com.wx.springcloud.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/15
 */
@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule(){
        return new RandomRule();
    }
}
