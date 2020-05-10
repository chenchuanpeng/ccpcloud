package com.ccp.springcloud.service;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("payment/get/{id}")
    CommonResult<Payment> selectOne(@PathVariable("id") Long id);

    @GetMapping("payment/feignTimeOut")
    String paymentFeignTimeOut();

}
