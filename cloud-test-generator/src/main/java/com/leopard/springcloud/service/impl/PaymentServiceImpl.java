package com.leopard.springcloud.service.impl;

import com.leopard.springcloud.entity.Payment;
import com.leopard.springcloud.mapper.PaymentMapper;
import com.leopard.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 付款表 服务实现类
 * </p>
 *
 * @author leo-zu
 * @since 2020-10-18
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public Payment findEntityById(BigDecimal id) {
        return paymentMapper.selectById(id);
    }
}
