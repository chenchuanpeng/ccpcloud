package com.ccp.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RateLimitController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource",blockHandler = "byResource_blockHandler")
    public CommonResult<Payment> byResource(){
//        FlowControllerV
        return new CommonResult<>(200,"成功",new Payment(100L, UUID.randomUUID().toString()));
    }

    public CommonResult<Payment> byResource_blockHandler(BlockException e){
        return new CommonResult<>(500,e.getClass().getCanonicalName()+"失败");
    }
}
