package com.leopard.springcloud.service;

import com.leopard.springcloud.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 * 付款表 服务类
 * </p>
 *
 * @author leo-zu
 * @since 2020-10-18
 */
public interface PaymentService extends IService<Payment> {

    Payment findEntityById(BigDecimal id);
}
