package com.leopard.springcloud.mapper;

import com.leopard.springcloud.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 付款表 Mapper 接口
 * </p>
 *
 * @author leo-zu
 * @since 2020-10-18
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

    List<Payment> findAll();
}
