package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.TStorage;
import com.ccp.springcloud.service.TStorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStorage)表控制层
 *
 * @author makejava
 * @since 2020-04-20 22:18:07
 */
@RestController
@RequestMapping("tStorage")
public class TStorageController {
    /**
     * 服务对象
     */
    @Resource
    private TStorageService tStorageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TStorage selectOne(Long id) {
        return this.tStorageService.queryById(id);
    }

    @PostMapping(value = "decrease")
    public CommonResult decrease(@RequestParam("productId")Long productId, @RequestParam("count")Integer count){
        this.tStorageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    }

}