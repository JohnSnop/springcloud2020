package com.wf.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-04-22 21:24
 * @desc
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();
        // http://news.baidu.com/guonei
        routes.route("path_route_simple", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
