package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.TOrder;
import com.ccp.springcloud.service.TOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-04-19 16:45:05
 */
@RestController
@RequestMapping("tOrder")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TOrder selectOne(Long id) {
        return this.tOrderService.queryById(id);
    }

    @GetMapping(value = "createOrder")
    public CommonResult createOrder(TOrder order){
        this.tOrderService.createOrder(order);
        return new CommonResult(200,"创建订单成功",order);
    }

}