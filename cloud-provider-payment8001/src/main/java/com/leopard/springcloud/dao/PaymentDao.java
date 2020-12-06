package com.leopard.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leopard.springcloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author leo-zu
 * @create 2020-10-03 10:04
 */
@Mapper
public interface PaymentDao {

    public int create(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentEntity(@Param("id") BigDecimal id);

    List<PaymentEntity> getALLPaymentEntity();
}
