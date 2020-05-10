package com.ccp.springcloud.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-04-19 16:45:00
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = -30806014982425582L;
    
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 产品ID
    */
    private Long productId;
    /**
    * 数量
    */
    private Integer count;
    /**
    * 金额
    */
    private BigDecimal money;
    /**
    * 状态 0：创建中 1：已完成
    */
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}