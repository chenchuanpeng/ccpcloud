package com.ccp.springcloud.service.impl;

import com.ccp.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceFallbackImpl implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "--- PaymentHystrixServiceFallbackImpl payment_ok o(╥﹏╥)o ---";
    }

    @Override
    public String payment_timeOut(Integer id) {
        return "--- PaymentHystrixServiceFallbackImpl payment_timeOut o(╥﹏╥)o ---";
    }
}
