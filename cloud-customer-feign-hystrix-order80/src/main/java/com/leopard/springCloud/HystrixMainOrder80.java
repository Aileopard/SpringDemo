package com.leopard.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author leo-zu
 * @create 2020-11-01 16:31
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMainOrder80.class,args);
    }
}
