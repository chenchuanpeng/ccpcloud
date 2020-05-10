package com.ccp.springcloud.entity;

import java.io.Serializable;

/**
 * (TStorage)实体类
 *
 * @author makejava
 * @since 2020-04-20 22:18:04
 */
public class TStorage implements Serializable {
    private static final long serialVersionUID = 456462713801113492L;
    
    private Long id;
    /**
    * 产品ID
    */
    private Long productId;
    /**
    * 总库存
    */
    private Integer total;
    /**
    * 已用库存
    */
    private Integer used;
    /**
    * 剩余库存
    */
    private Integer residue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

}