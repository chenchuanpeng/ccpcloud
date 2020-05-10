package com.ccp.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulOrder")
public class ConsulOrderController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://provider-consul-payment";

    @GetMapping("payment")
    public String payment(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}
