package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("orderFeign")
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("payment/feignTimeOut")
    public String paymentFeignTimeOut(){
        // openFeign-ribbon默认等待时间为1s
        return paymentFeignService.paymentFeignTimeOut();
    }

}
