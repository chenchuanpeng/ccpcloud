package com.ccp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping(value = "orderZk")
public class OrderZkController {
    private static final String URL = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "payment")
    public String payment(){
        return restTemplate.getForObject(URL+"/payment/zk",String.class);
    }
}
