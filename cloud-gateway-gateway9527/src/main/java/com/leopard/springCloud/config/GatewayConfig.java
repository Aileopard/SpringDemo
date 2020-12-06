package com.leopard.springCloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leo-zu
 * @create 2020-12-06 18:37
 */
@Configuration
public class GatewayConfig {
    /**
     * 方法二：编码方式实现转发路由
     * 配置一个id为route-name的路由规则，
     * 当访问地址http://localhost:9527/guonei时，会自动转发到地址：http://news.baidu.com/guonei
     * @param rlb
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder rlb){

        RouteLocatorBuilder.Builder routes = rlb.routes();

        // id：唯一
        // 描述：当访问http://localhost:9527/guonei时，会转发路由到百度的国内新闻
        routes.route("path_route_leo",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();

        routes.route("path_route_leo2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();

        return routes.build();
    }

    /**
     * 和上面一样，可以写多个@Bean，也可以在一个方法中的routers中构建多个转发路由地址
     * @param rlb
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator2(RouteLocatorBuilder rlb){

        RouteLocatorBuilder.Builder routes = rlb.routes();
        routes.route("path_route_leo2",
                r -> r.path("/finance")
                        .uri("http://news.baidu.com/finance"))
                .build();
        return routes.build();
    }
}
