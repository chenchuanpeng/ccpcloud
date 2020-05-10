package com.ccp.springcloud.service.impl;

import com.ccp.springcloud.entity.TOrder;
import com.ccp.springcloud.dao.TOrderDao;
import com.ccp.springcloud.service.TAccountService;
import com.ccp.springcloud.service.TOrderService;
import com.ccp.springcloud.service.TStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 16:45:05
 */
@Service("tOrderService")
@Slf4j
public class TOrderServiceImpl implements TOrderService {
    @Autowired
    private TOrderDao tOrderDao;

    @Autowired
    private TStorageService tStorageService;
    @Autowired
    private TAccountService tAccountService;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrder queryById(Long id) {
        return this.tOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TOrder> queryAllByLimit(int offset, int limit) {
        return this.tOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder insert(TOrder tOrder) {
        this.tOrderDao.insert(tOrder);
        return tOrder;
    }

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder update(TOrder tOrder) {
        this.tOrderDao.update(tOrder);
        return this.queryById(tOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tOrderDao.deleteById(id) > 0;
    }

    @Override
    @GlobalTransactional(name = "ccp_tx_group",rollbackFor = {Exception.class})
    public void createOrder(TOrder order) {
        // 创建订单
        log.info("创建订单");
        order.setStatus(0);
        tOrderDao.insert(order);
        // 扣减库存
        log.info("扣减库存");
        tStorageService.decrease(order.getProductId(),order.getCount());
        // 扣减账户余额
        log.info("扣减账户余额");
        tAccountService.decrease(order.getUserId(),order.getMoney());
        log.info("修改订单状态");
        order.setStatus(1);
        tOrderDao.update(order);
    }
}