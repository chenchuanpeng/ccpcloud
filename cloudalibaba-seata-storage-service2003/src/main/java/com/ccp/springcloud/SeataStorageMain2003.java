package com.ccp.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动装配
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"com.ccp.springcloud.dao"})
public class SeataStorageMain2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2003.class,args);
    }

}
