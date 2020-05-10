package com.ccp.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ccp.springcloud.controller.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private OrderService orderService;


    @GetMapping("testA")
    public String testA(){
        String order = orderService.getOrder();
        log.info("testA"+"__"+order);
        return "_______testA_________";
    }

    @GetMapping("testB")
    public String testB(){
        String order = orderService.getOrder();
        log.info("testB"+"__"+order);
        return "_______testB_________";
    }



    @GetMapping("testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test 测试RT");
        return "_______testC_________";
    }

    @GetMapping("testD")
    public String testD(){
        int i = 10 / 0;
        log.info("test 测试异常数");
        return "_______testD 测试异常数_________";
    }

    @GetMapping("testE")
    @SentinelResource(value = "testE",blockHandler = "testE_blockHandler")
    public String testE(@RequestParam(value = "p1",required = false)String p1,
                        @RequestParam(value = "p2",required = false)String p2){
        return "testE Hot Key";
    }

    public String testE_blockHandler(String p1, String p2, BlockException e){
        log.info("p1="+p1+"\t p2 = "+p2);
        log.info(e.getMessage());
        return "testE_blockHandler Hot Key";
    }

}
