package com.zhazhapan.efo.model;

public class CodeContent {

    private String qrCodeId;

    private String content;

    public CodeContent(String qrCodeId, String content) {
        this.qrCodeId = qrCodeId;
        this.content = content;
    }

    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
