package com.ccp.springcloud.controller;

import com.ccp.springcloud.entity.CommonResult;
import com.ccp.springcloud.entity.TAccount;
import com.ccp.springcloud.service.TAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * (TAccount)表控制层
 *
 * @author makejava
 * @since 2020-04-20 22:02:31
 */
@RestController
@RequestMapping("tAccount")
public class TAccountController {
    /**
     * 服务对象
     */
    @Resource
    private TAccountService tAccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TAccount selectOne(Long id) {
        return this.tAccountService.queryById(id);
    }

    @PostMapping(value = "decrease")
    public CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money){
        this.tAccountService.decrease(userId,money);
        return new CommonResult(200,"更改账户余额成功！");
    }

}