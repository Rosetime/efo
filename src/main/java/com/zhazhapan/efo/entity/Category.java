package com.zhazhapan.efo.entity;

import com.zhazhapan.efo.util.BeanUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 分类表
 *
 * @author pantao
 * @since 2018/1/11
 */
public class Category {

    private int id;

    /**
     * 分类名称
     */
    private String name;

    private LocalDateTime createTime;

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return BeanUtils.toPrettyJson(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
