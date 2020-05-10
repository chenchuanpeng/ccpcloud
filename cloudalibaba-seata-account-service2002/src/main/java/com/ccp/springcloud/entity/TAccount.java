package com.ccp.springcloud.entity;

import java.io.Serializable;

/**
 * (TAccount)实体类
 *
 * @author makejava
 * @since 2020-04-20 22:02:28
 */
public class TAccount implements Serializable {
    private static final long serialVersionUID = 270141588272085945L;
    
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 总额度
    */
    private Double total;
    /**
    * 已用额度
    */
    private Double used;
    /**
    * 剩余额度
    */
    private Double residue;


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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getUsed() {
        return used;
    }

    public void setUsed(Double used) {
        this.used = used;
    }

    public Double getResidue() {
        return residue;
    }

    public void setResidue(Double residue) {
        this.residue = residue;
    }

}