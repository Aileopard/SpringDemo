package com.leopard.springcloud.controller;

import com.leopard.springcloud.entities.CommonResult;
import com.leopard.springcloud.entities.PaymentEntity;
import com.leopard.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author leo-zu
 * @create 2020-10-03 10:23
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody PaymentEntity paymentEntity){

        int result = paymentService.create(paymentEntity);
        log.info("**** 开始插入 ****" + result);
        if(result > 0){
            return new CommonResult(200,"插入成功,serverPort="+serverPort,null);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/getPaymentEntity/{id}")
    public CommonResult getPaymentEntity(@PathVariable BigDecimal id){

        PaymentEntity result = paymentService.getPaymentEntity(id);
        log.info("**** 开始查找 ****" + result);
        if(result != null){
            return new CommonResult(200,"查找成功,serverPort="+serverPort,result);
        }else{
            return new CommonResult(400,"没有对应的记录，查询id="+id,null);
        }
    }
}
