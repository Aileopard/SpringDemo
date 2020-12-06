package com.leopard.springcloud.controller;

import com.leopard.springcloud.entities.CommonResult;
import com.leopard.springcloud.entities.PaymentEntity;
import com.leopard.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author leo-zu
 * @create 2020-10-03 10:23
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        // 获取注册中心有哪些微服务
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("*** element = "+element);
        }

        // 获取CLOUD-PAYMENT-SERVICE服务下有哪些实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return this.serverPort;
    }
}
