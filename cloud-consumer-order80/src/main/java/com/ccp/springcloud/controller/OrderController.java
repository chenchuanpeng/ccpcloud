package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URI="http://localhost:8001/";
    private static final String PAYMENT_URI="http://CLOUD-PROVIDER-PAYMENT/";

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("restTemplateNoLB")
    private RestTemplate restTemplate2;

    @Autowired
    private LoadBalance loadBalance;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URI+"payment/get/"+id,CommonResult.class);
    }
    @GetMapping(value = "create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URI+"payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "getForEntity/{id}")
    public CommonResult get2(@PathVariable("id")Long id){
        final ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URI + "payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(500,"获取失败");
        }
    }

    @GetMapping(value = "createForEntity")
    public CommonResult createForEntity(Payment payment){
        return restTemplate.postForEntity(PAYMENT_URI+"payment/create",payment,CommonResult.class).getBody();
    }

    /**
     * 自己定义负载均衡的算法
     * @return
     */
    @RequestMapping("lb")
    public String paymentLB(){
        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if(instances == null || instances.isEmpty()){
            return null;
        }
        final ServiceInstance instances1 = loadBalance.instances(instances);
        return restTemplate2.getForObject(instances1.getUri()+"/payment/lb",String.class);
    }

    @GetMapping(value = "zipkin")
    public String zipkin(){
        return restTemplate.getForObject(PAYMENT_URI+"payment/zipkin",String.class);
    }

}
