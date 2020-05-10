package com.ccp.springcloud.service;

import com.ccp.springcloud.entity.TStorage;
import java.util.List;

/**
 * (TStorage)表服务接口
 *
 * @author makejava
 * @since 2020-04-20 22:18:06
 */
public interface TStorageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStorage queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TStorage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 实例对象
     */
    TStorage insert(TStorage tStorage);

    /**
     * 修改数据
     *
     * @param tStorage 实例对象
     * @return 实例对象
     */
    TStorage update(TStorage tStorage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void decrease(Long productId, Integer count);
}