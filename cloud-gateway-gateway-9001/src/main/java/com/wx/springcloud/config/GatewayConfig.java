package com.wx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/21
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator1(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("baidu_guonei",
                f -> f.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        return routes.build();
    }

    @Bean
    public RouteLocator routeLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("baidu_guoji",
                f -> f.path("/guoji")
                        .uri("http://news.baidu.com/guoji"));
        return routes.build();
    }

}
