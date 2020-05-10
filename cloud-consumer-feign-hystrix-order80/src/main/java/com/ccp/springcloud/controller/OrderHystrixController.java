package com.ccp.springcloud.controller;

import com.ccp.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("order/hystrix")
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentHystrixService.payment_ok(id);
    }

    @GetMapping("timeOut/{id}")
    /*@HystrixCommand(fallbackMethod = "payment_timeOutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public String payment_timeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.payment_timeOut(id);
    }

    public String payment_timeOutFallback(@PathVariable("id") Integer id){
        return "OrderHystrixMain80,系统错误响应，请重试！";
    }

    public String payment_global_fallback(){
        return "payment_global_fallback 全局方法";
    }


}
