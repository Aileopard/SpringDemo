package com.leopard.springcloud.service.impl;

import com.leopard.springcloud.dao.PaymentDao;
import com.leopard.springcloud.entities.PaymentEntity;
import com.leopard.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author leo-zu
 * @create 2020-10-03 10:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(PaymentEntity paymentEntity) {
        return paymentDao.create(paymentEntity);
    }

    @Override
    public PaymentEntity getPaymentEntity(BigDecimal id) {
        return paymentDao.getPaymentEntity(id);
    }
}
