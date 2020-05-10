package com.ccp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {
    @Value(value = "${config.info}")
    private String configInfo;

    @GetMapping("configInfo")
    public String configInfo(){
        return configInfo;
    }
}
