package com.ccp.springcloud.service.impl;

import com.ccp.springcloud.entity.TAccount;
import com.ccp.springcloud.dao.TAccountDao;
import com.ccp.springcloud.service.TAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * (TAccount)表服务实现类
 *
 * @author makejava
 * @since 2020-04-20 22:02:31
 */
@Service("tAccountService")
public class TAccountServiceImpl implements TAccountService {
    @Resource
    private TAccountDao tAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TAccount queryById(Long id) {
        return this.tAccountDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TAccount> queryAllByLimit(int offset, int limit) {
        return this.tAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tAccount 实例对象
     * @return 实例对象
     */
    @Override
    public TAccount insert(TAccount tAccount) {
        this.tAccountDao.insert(tAccount);
        return tAccount;
    }

    /**
     * 修改数据
     *
     * @param tAccount 实例对象
     * @return 实例对象
     */
    @Override
    public TAccount update(TAccount tAccount) {
        this.tAccountDao.update(tAccount);
        return this.queryById(tAccount.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tAccountDao.deleteById(id) > 0;
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        this.tAccountDao.decrease(userId,money);
    }
}