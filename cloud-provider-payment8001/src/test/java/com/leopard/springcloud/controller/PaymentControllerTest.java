package com.leopard.springcloud.controller;

import com.leopard.springcloud.entities.PaymentEntity;
import com.leopard.springcloud.service.PaymentService;
import com.leopard.springcloud.service.impl.PaymentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;

/**
 * @author leo-zu
 * @create 2020-10-14 14:24
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {
    // 需要测试的接口类
    @InjectMocks
    private PaymentController paymentController;

    // 用到的服务
    @Mock
    private PaymentService paymentService;

    @Mock
    private DiscoveryClient discoveryClient;

    @Test
    public void should_return_CommonResult_when_create_given_params() {
        PaymentEntity entity = new PaymentEntity();
        int exceptedResult = 1;
        Mockito.when(paymentService.create(any(PaymentEntity.class))).thenReturn(exceptedResult);
        paymentController.create(entity);
    }

    @Test
    public void should_return_CommonResult2_when_create_given_params() {
        PaymentEntity entity = new PaymentEntity();
        int exceptedResult = -1;
        Mockito.when(paymentService.create(any(PaymentEntity.class))).thenReturn(exceptedResult);
        paymentController.create(entity);
    }

    @Test
    public void should_return_CommonResult_when_getPaymentEntity_given_params() {
        PaymentEntity entity = new PaymentEntity();
        Mockito.when(paymentService.getPaymentEntity(any(BigDecimal.class))).thenReturn(entity);
        BigDecimal bigDecimal = new BigDecimal(1);
        paymentController.getPaymentEntity(bigDecimal);
    }

    @Test
    public void should_return_CommonResult2_when_getPaymentEntity_given_params() {
        PaymentEntity entity = null;
        Mockito.when(paymentService.getPaymentEntity(any(BigDecimal.class))).thenReturn(entity);
        BigDecimal bigDecimal = new BigDecimal(1);
        paymentController.getPaymentEntity(bigDecimal);
    }

    @Test
    public void should_return_Object_when_discovery_given_params() {
        String string = "aaa";
        List<String> services = new ArrayList<>();
        services.add(string);

        List<ServiceInstance> instances = new ArrayList<>();
        ServiceInstance serviceInstance = new ServiceInstance() {
            @Override
            public String getServiceId() {
                return "null";
            }

            @Override
            public String getHost() {
                return "null";
            }

            @Override
            public int getPort() {
                return 0;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public URI getUri() {
                return null;
            }

            @Override
            public Map<String, String> getMetadata() {
                return null;
            }
        };
        instances.add(serviceInstance);

                discoveryClient.getServices();
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        Mockito.when(discoveryClient.getServices()).thenReturn(services);
        Mockito.when(discoveryClient.getInstances(any(String.class))).thenReturn(instances);

        paymentController.discovery();
    }
}