package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.Payment;
import com.ccp.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-04-15 21:37:35
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommonResult<Payment> selectOne(Long id) {
        final Payment payment = paymentService.queryById(id);
        return new CommonResult<>(200,"查询成功！serverPort="+serverPort,payment);
    }

}