package com.leopard.springcloud.service;

import com.leopard.springcloud.dao.PaymentDao;
import com.leopard.springcloud.entities.PaymentEntity;
import com.leopard.springcloud.service.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author leo-zu
 * @create 2020-10-14 14:35
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PaymentServiceImpl.class, StringUtils.class})
public class PaymentServiceTest {
    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentDao paymentDao;



}