package com.ccp.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.ccp.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String payment_ok(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"\t payment_ok:"+id;
    }

    @HystrixCommand(fallbackMethod = "payment_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") })
    @Override
    public String payment_timeOut(Integer id) {
        int timeOut = 5;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"\t payment_timeOut:"+id+"\t ThrealSleep(s)="+timeOut+"^_^";
    }

    public String payment_timeOutHandler(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"\t 8001系统 payment_timeOutHandler:"+id+"\t o(╥﹏╥)o";
    }


    // -- 服务熔断

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功，流水号为："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "Id 不能为负数，请稍后重试！ID为："+id;
    }

}
