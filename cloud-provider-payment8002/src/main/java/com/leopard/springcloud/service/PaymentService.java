package com.leopard.springcloud.service;

import com.leopard.springcloud.entities.PaymentEntity;

import java.math.BigDecimal;

/**
 * @author leo-zu
 * @create 2020-10-03 10:16
 */
public interface PaymentService {
    public int create(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentEntity(BigDecimal id);
}
