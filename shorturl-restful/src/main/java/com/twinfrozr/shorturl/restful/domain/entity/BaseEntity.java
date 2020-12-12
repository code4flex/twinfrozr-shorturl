package com.twinfrozr.shorturl.restful.domain.entity;

import java.io.Serializable;

/**
 * baseEntity
 *
 * @author mavin
 * @date 2020-12-04
 */
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    private int createTime;

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }
}
