package com.ccp.springcloud.service.impl;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> selectOne(Long id) {
        return new CommonResult<>(444444,
                "openfeign 定义的全局降级方法 PaymentFallbackServiceImpl",
                new Payment(id, "PaymentFallbackServiceImpl error"));
    }
}
