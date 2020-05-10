package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleBreakerFeignConroller {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/feignSelect/{id}")
    public CommonResult<Payment> feignSelect(@PathVariable("id")Long id){
        return paymentService.selectOne(id);
    }

}
