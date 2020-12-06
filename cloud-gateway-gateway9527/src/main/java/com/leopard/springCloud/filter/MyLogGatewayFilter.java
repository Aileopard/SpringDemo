package com.leopard.springCloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author leo-zu
 * @create 2020-12-06 21:36
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********* 进入 MyLogGatewayFilter"+ new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("****** 用户名为null，非法用户");
            // 设置一个状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 完成
            return exchange.getResponse().setComplete();
        }
        // 去下一个过滤链进行过滤
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
