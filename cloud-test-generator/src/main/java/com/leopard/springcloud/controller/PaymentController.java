package com.leopard.springcloud.controller;


import com.leopard.springcloud.entities.CommonResult;
import com.leopard.springcloud.entity.Payment;
import com.leopard.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 付款表 前端控制器
 * </p>
 *
 * @author leo-zu
 * @since 2020-10-18
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/findEntityById/{id}")
    public CommonResult findEntityById(@PathVariable BigDecimal id){
        Payment entity = paymentService.findEntityById(id);
        if(entity != null) {
            return new CommonResult(200,"查找成功",entity);
        }else {
            return new CommonResult(404,"查找失败");
        }
    }
}

