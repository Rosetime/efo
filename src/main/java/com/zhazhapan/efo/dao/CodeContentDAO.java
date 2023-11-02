package com.zhazhapan.efo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author haoyuLiu
 * @Date 2023-10-30
 */
@Repository
public interface CodeContentDAO {

    @Insert("insert into code_content(qr_code_id, content) values(#{qrCodeId}, #{content})")
    int insertContent(@Param("qrCodeId") String qrCodeId, @Param("content") String content);

    @Select("select content from code_content where qr_code_id = #{qrCodeId} limit 1")
    String queryContent(@Param("qrCodeId") String qrCodeId);
}
