package com.ywj.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YaoWenJun
 * @date 2022/10/13 16:40
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // http://news.baidu.com/guonei
        RouteLocator path_route_ywj = routes.route("path_route_ywj",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return path_route_ywj;
    }






    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator pay_route_guoji = routes.route("pay_route_guoji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return pay_route_guoji;
    }











}





