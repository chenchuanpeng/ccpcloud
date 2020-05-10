package com.ccp.springcloud.dao;

import com.ccp.springcloud.entity.TStorage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TStorage)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 22:18:05
 */
public interface TStorageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStorage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TStorage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tStorage 实例对象
     * @return 对象列表
     */
    List<TStorage> queryAll(TStorage tStorage);

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int insert(TStorage tStorage);

    /**
     * 修改数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int update(TStorage tStorage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}