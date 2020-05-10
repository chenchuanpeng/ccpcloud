package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-03-22 18:24:07
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;

    @Value(value = "${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        try {
            log.info("查询ID为："+id);
            Payment payment = paymentService.queryById(id);
            return new CommonResult(200,"成功，serverPort="+serverPort,payment);
        } catch (Exception e) {
            log.error("查询失败！");
            return new CommonResult(500,"失败");
        }
    }

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        try {
            Payment insert = paymentService.insert(payment);
            return new CommonResult<>(200,"成功，serverPort="+serverPort,insert);
        } catch (Exception e) {
            log.error("查询失败！");
            return new CommonResult<>(500,"失败");
        }
    }

    @GetMapping(value = "discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(s-> System.out.println(s));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getScheme()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping("lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("feignTimeOut")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }

    // sleuth + zipkin

    @GetMapping("zipkin")
    public String zipkin(){
        return "payment sleuth zipkin";
    }

}