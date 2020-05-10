package com.ccp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerNacosOrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping(value = "consumer/payment/{id}")
    public String paymrntInfo(@PathVariable("id")String id){
        return restTemplate.getForObject(serviceUrl+"/payment/nacos/"+id,String.class);
    }
}
