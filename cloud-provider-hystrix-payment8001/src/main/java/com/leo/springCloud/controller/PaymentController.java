package com.leo.springCloud.controller;

import com.leo.springCloud.service.PaymentService;
import com.leopard.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author leo-zu
 * @create 2020-11-01 11:46
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        if(result == null){
            // 表中没有这条记录
            return new CommonResult(404,"表中没有这条记录，server port="+serverPort,null);
        }else{
            return new CommonResult(200,paymentService.paymentInfo_OK(id),null);
        }
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommonResult paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        if (result == null){
            // 表中没有这条记录
            return new CommonResult(404,"表中没有这条记录，server port="+serverPort,null);

        }else{
            return new CommonResult(200,result,null);
        }
    }

}
