package com.ccp.springcloud.service;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "nacos-provider-payment",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/selectOne")
    CommonResult<Payment> selectOne(@RequestParam("id") Long id);

}
