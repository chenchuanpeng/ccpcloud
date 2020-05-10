package com.ccp.springcloud.service;

public interface PaymentService {

    String payment_ok(Integer id);

    String payment_timeOut(Integer id);

    String payment_timeOutHandler(Integer id);

    String paymentCircuitBreaker(Integer id);
}
