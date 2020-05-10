package com.ccp.springcloud.service;

import com.ccp.springcloud.entity.TAccount;

import java.math.BigDecimal;
import java.util.List;

/**
 * (TAccount)表服务接口
 *
 * @author makejava
 * @since 2020-04-20 22:02:30
 */
public interface TAccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAccount queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TAccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tAccount 实例对象
     * @return 实例对象
     */
    TAccount insert(TAccount tAccount);

    /**
     * 修改数据
     *
     * @param tAccount 实例对象
     * @return 实例对象
     */
    TAccount update(TAccount tAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void decrease(Long userId, BigDecimal money);
}