package com.zhazhapan.efo.entity;

import com.zhazhapan.efo.util.BeanUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 下载记录表
 *
 * @author pantao
 * @since 2018/1/11
 */
public class Download {

    private long id;

    private LocalDateTime createTime;

    private int userId;

    private int fileId;

    public Download(int userId, int fileId) {
        this.userId = userId;
        this.fileId = fileId;
    }

    public Download(int id, LocalDateTime createTime, int userId, int fileId) {
        this.id = id;
        this.createTime = createTime;
        this.userId = userId;
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return BeanUtils.toPrettyJson(this);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
