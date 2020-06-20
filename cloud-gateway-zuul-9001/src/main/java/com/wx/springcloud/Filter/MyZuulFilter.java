package com.wx.springcloud.Filter;

import cn.hutool.Hutool;
import cn.hutool.core.lang.caller.SecurityManagerCaller;
import cn.hutool.crypto.SecureUtil;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/20
 */
public class MyZuulFilter extends com.netflix.zuul.ZuulFilter {
    @Override
    public String filterType() {
        // 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
        // 1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
        // 2、route：在进行路由请求的时候被调用；
        // 3、post：在路由之后发送请求信息的时候被调用；
        // 4、error：出现错误之后进行调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //优先级
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //该Filter是否要执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println("MyZuulFilter..." + request.getMethod()+","+request.getRequestURI());
        return null;
    }
}
