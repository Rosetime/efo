package com.zhazhapan.efo.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author pantao
 * @since 2018/3/1
 */
public class FileBasicRecord {

    private long id;

    private String username;

    private String localUrl;

    private String categoryName;

    private String visitUrl;

    private int downloadTimes;

    private LocalDateTime createTime;

    public FileBasicRecord(long id, String username, String localUrl, String categoryName, String visitUrl, int
            downloadTimes, LocalDateTime createTime) {
        this.id = id;
        this.username = username;
        this.localUrl = localUrl;
        this.categoryName = categoryName;
        this.visitUrl = visitUrl;
        this.downloadTimes = downloadTimes;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }

    public int getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(int downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
