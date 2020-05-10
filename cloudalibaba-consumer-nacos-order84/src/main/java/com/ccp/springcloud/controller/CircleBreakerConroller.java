package com.ccp.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircleBreakerConroller {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "fallbackHandler",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id")Long id){
        final CommonResult<Payment> result = restTemplate.getForObject(serverURL + "/payment/selectOne?id="+id, CommonResult.class);
        if(id == 1){
            throw new IllegalArgumentException("非法参数异常");
        }
        if(result.getData() == null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> fallbackHandler(Long id,Throwable throwable){
        return new CommonResult<>(500,"fallbackHandler "+throwable.getMessage(),new Payment(id,"fallbackHandler"));
    }

    public CommonResult<Payment> blockHandler(Long id, BlockException e){
        return new CommonResult<>(500,"blockHandler "+e.getMessage(),new Payment(id,"blockHandler"));
    }
}
