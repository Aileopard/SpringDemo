package com.leopard.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author leo-zu
 * @create 2020-10-03 9:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity implements Serializable {
    private BigDecimal id; // 主键
    private String serial; //
}
