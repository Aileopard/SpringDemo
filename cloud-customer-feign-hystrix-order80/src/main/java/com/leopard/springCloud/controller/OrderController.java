package com.leopard.springCloud.controller;

import com.leopard.springCloud.service.PaymentHystrixService;
import com.leopard.springcloud.entities.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author leo-zu
 * @create 2020-11-01 16:42
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("server.port")
    private String serverPort;

    @GetMapping("/order/hystrix/paymentInfo_ok/{id}")
    @HystrixCommand
    public CommonResult paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        if (result == null){
            return new CommonResult(404,"表中没有该记录，server port="+serverPort,null);
        }else {
            return new CommonResult(200,result,null);
        }
    }

    @GetMapping("/order/hystrix/paymentInfo_TimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
    })
    public CommonResult paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        if (result == null){
            return new CommonResult(404,"表中没有该记录，server port="+serverPort,null);
        }else {
            return new CommonResult(200,result,null);
        }
    }

    /**
     * 特别针对超时服务进行降级
     * @param id
     * @return
     */
    public CommonResult paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        String result = "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬),id="+id;
        return new CommonResult(303,result,null);
    }

    /**
     * 全局通用的fallback
     * @return
     */
    public CommonResult paymentGlobalFallbackMethod(){
        String result = "支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
        return new CommonResult(300,result,null);
    }
}
