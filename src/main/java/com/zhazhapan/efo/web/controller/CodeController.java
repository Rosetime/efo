package com.zhazhapan.efo.web.controller;

import com.zhazhapan.efo.dao.CodeContentDAO;
import com.zhazhapan.efo.model.CodeContent;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author haoyuLiu
 * @Date 2023-10-31
 */
@RestController
@RequestMapping("code")
@Api(value = "code", description = "获取二维码内容")
public class CodeController {

    @Autowired
    CodeContentDAO codeContentDAO;

    @PostMapping("")
    public boolean add(@RequestBody CodeContent content) {
        codeContentDAO.insertContent(content.getQrCodeId(), content.getContent());
        return true;
    }

    @GetMapping("{qrCodeId}")
    public String get(@PathVariable("qrCodeId") String qrCodeId) {
        return codeContentDAO.queryContent(qrCodeId);
    }

}
