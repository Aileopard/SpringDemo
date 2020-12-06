package com.leopard.springcloud.controller;

import com.leopard.springcloud.entities.CommonResult;
import com.leopard.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author leo-zu
 * @create 2020-10-03 15:46
 */
@RestController
@Slf4j
public class OrderController {
//    public final String PAYMENT_URL="http://localhost:8001";
    public final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<PaymentEntity> create(PaymentEntity paymentEntity){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",paymentEntity,CommonResult.class);
    }


    @GetMapping("/consumer/payment/getPaymentEntity/{id}")
    public CommonResult<PaymentEntity> getPaymentEntity(@PathVariable BigDecimal id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentEntity/"+id,CommonResult.class);
    }
}
