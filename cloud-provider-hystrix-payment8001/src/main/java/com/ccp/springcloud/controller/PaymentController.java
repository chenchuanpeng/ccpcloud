package com.ccp.springcloud.controller;

import com.ccp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        return paymentService.payment_ok(id);
    }

    @GetMapping("payment/timeOut/{id}")
    public String payment_timeOut(@PathVariable("id") Integer id){
        return paymentService.payment_timeOut(id);
    }

    // -----服务熔断
    @GetMapping("payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
