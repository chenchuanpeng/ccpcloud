package com.ccp.springcloud.service;

import com.ccp.springcloud.service.impl.PaymentHystrixServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceFallbackImpl.class)
public interface PaymentHystrixService {

    @GetMapping("payment/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("payment/timeOut/{id}")
    String payment_timeOut(@PathVariable("id") Integer id);
}
