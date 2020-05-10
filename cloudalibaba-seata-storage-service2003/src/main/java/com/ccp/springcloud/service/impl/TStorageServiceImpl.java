package com.ccp.springcloud.service.impl;

import com.ccp.springcloud.entity.TStorage;
import com.ccp.springcloud.dao.TStorageDao;
import com.ccp.springcloud.service.TStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TStorage)表服务实现类
 *
 * @author makejava
 * @since 2020-04-20 22:18:06
 */
@Service("tStorageService")
public class TStorageServiceImpl implements TStorageService {
    @Resource
    private TStorageDao tStorageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TStorage queryById(Long id) {
        return this.tStorageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TStorage> queryAllByLimit(int offset, int limit) {
        return this.tStorageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 实例对象
     */
    @Override
    public TStorage insert(TStorage tStorage) {
        this.tStorageDao.insert(tStorage);
        return tStorage;
    }

    /**
     * 修改数据
     *
     * @param tStorage 实例对象
     * @return 实例对象
     */
    @Override
    public TStorage update(TStorage tStorage) {
        this.tStorageDao.update(tStorage);
        return this.queryById(tStorage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tStorageDao.deleteById(id) > 0;
    }

    @Override
    public void decrease(Long productId, Integer count) {
        int i = 10/0;
        this.tStorageDao.decrease(productId,count);
    }
}