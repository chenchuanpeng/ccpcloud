package com.ccp.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        // 访问 http://localhost:9527/guonei 会转发到 http://news.baidu.com/guonei
        return routes.route("path_baidu_new",
                predicateSpec -> predicateSpec.path("/guonei")
                        .uri("http://news.baidu.com/")).build();
    }
}
