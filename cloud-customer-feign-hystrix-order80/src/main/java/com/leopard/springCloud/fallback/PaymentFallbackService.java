package com.leopard.springCloud.fallback;

import com.leopard.springCloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author leo-zu
 * @create 2020-11-01 20:28
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        String result = "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
        return result;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        String result = "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
        return result;
    }
}
