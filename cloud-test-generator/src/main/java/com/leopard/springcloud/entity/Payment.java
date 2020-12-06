package com.leopard.springcloud.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 付款表
 * </p>
 *
 * @author leo-zu
 * @since 2020-10-18
 */
public class Payment extends Model<Payment> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * serial
     */
    private String serial;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Payment{" +
        "id=" + id +
        ", serial=" + serial +
        "}";
    }
}
