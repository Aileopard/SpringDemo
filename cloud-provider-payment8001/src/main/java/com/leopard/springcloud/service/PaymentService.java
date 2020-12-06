package com.leopard.springcloud.service;

import com.leopard.springcloud.dao.PaymentDao;
import com.leopard.springcloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author leo-zu
 * @create 2020-10-03 10:16
 */
public interface PaymentService {
    public int create(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentEntity(BigDecimal id);

    public List<PaymentEntity> getALLPaymentEntity();
}
