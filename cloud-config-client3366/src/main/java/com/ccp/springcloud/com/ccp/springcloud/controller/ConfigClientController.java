package com.ccp.springcloud.com.ccp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value(value = "${config.info}")
    private String configInfo;
    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping("configInfo")
    public String configInfo(){
        return "serverPort:"+serverPort+" \t configInfo:"+configInfo;
    }

}
