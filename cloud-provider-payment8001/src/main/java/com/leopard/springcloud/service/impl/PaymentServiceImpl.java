package com.leopard.springcloud.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leopard.springcloud.dao.PaymentDao;
import com.leopard.springcloud.entities.PaymentEntity;
import com.leopard.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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
//        paymentDao.selectList(null).forEach(System.out::println);
        return paymentDao.getPaymentEntity(id);
    }

    @Override
    public List<PaymentEntity> getALLPaymentEntity() {
        List<PaymentEntity> list = paymentDao.getALLPaymentEntity();
//        paymentDao.selectList(null).forEach(System.out::println);
        return list;
    }
}
