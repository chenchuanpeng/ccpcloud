package com.ccp.springcloud.controller.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @SentinelResource(value = "getOrder")
    public String getOrder(){
        return "order";
    }

}
