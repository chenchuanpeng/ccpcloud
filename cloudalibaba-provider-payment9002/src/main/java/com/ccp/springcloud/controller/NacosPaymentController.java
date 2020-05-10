package com.ccp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NacosPaymentController {

    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping(value = "payment/nacos/{id}")
    public String getPayment(@PathVariable("id")String id){
        return "Nacos Payment，serverPort="+serverPort+"\t id="+id;
    }
}
