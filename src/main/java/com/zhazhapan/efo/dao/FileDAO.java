package com.zhazhapan.efo.dao;

import com.zhazhapan.efo.dao.sqlprovider.FileSqlProvider;
import com.zhazhapan.efo.entity.File;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author pantao
 * @date 2018/1/19
 */
@Repository
public interface FileDAO {

    /**
     * 添加一个文件
     *
     * @param file {@link File}
     */
    @Insert("insert into file(name,suffix,local_url,visit_url,size,description,tag,user_id,category_id,is_downloadable,is_uploadable,is_deletable,is_updatable,is_visible) values(#{name},#{suffix},#{localUrl},#{visitUrl},#{size},#{description},#{tag},#{userId},#{categoryId},#{isDownloadable},#{isUploadable},#{isDeletable},#{isUpdatable},#{isVisible})")
    void insertFile(File file);

    /**
     * 删除一个文件
     *
     * @param id 文件编号
     */
    @Delete("delete from file where id=#{id}")
    void deleteFileById(int id);

    /**
     * 删除文件
     *
     * @param userId 用户编号
     */
    @Delete("delete from file where user_id=#{userId}")
    void deleteFileByUserId(int userId);

    /**
     * 删除文件
     *
     * @param categoryId 分类编号
     */
    @Delete("delete from file where category_d=#{categoryId}")
    void deleteFileByCategoryId(int categoryId);

    /**
     * 更新文件权限
     *
     * @param id 编号
     * @param isDownloadable 下载权限
     * @param isUploadable 上传权限
     * @param isVisible 可查权限
     * @param isDeletable 删除权限
     * @param isUpdatable 上传权限
     */
    @UpdateProvider(type = FileSqlProvider.class, method = "updateAuthById")
    void updateAuthById(@Param("id") int id, @Param("isDownloadable") int isDownloadable, @Param("isUploadable") int isUploadable, @Param("isVisible") int isVisible, @Param("isDeletable") int isDeletable, @Param("isUpdatable") int isUpdatable);

    /**
     * 更新文件名
     *
     * @param id 编号
     * @param name 文件名
     * @param suffix 后缀名
     */
    @Update("update file set name=#{name},suffix=#{suffix},last_modify_time=current_timestamp where id=#{id}")
    void updateFileNameById(@Param("id") int id, @Param("name") String name, @Param("suffix") String suffix);

    /**
     * 更新文件修改时间
     *
     * @param id 编号
     */
    @Update("update file set last_modify_time=current_timestamp where id=#{id}")
    void updateLastModifyTimeById(int id);

    /**
     * 更新文件本地路径
     *
     * @param id 编号
     * @param localUrl 本地路径
     */
    @Update("update file set local_url=#{localUrl} where id=#{id}")
    void updateLocalUrlById(@Param("id") int id, @Param("localUrl") String localUrl);

    /**
     * 更新文件访问路径
     *
     * @param id 编号
     * @param visitUrl 访问链接
     */
    @Update("update file set visit_url=#{visitUrl} where id=#{id}")
    void updateVisitUrlById(@Param("id") int id, @Param("visitUrl") String visitUrl);

    /**
     * 更新文件描述
     *
     * @param id 文件编号
     * @param description 描述
     */
    @Update("update file set description=#{description} where id=#{id}")
    void updateDescriptionById(@Param("id") int id, @Param("description") String description);

    /**
     * 更新文件查看次数
     *
     * @param id 编号
     */
    @Update("update file set check_times=check_times+1 where id=#{id}")
    void updateCheckTimesById(int id);

    /**
     * 更新文件下载次数
     *
     * @param id 编号
     */
    @Update("update file set download_times=download_times+1 where id=#{id}")
    void updateDownloadTimesById(int id);

    /**
     * 更新文件标签
     *
     * @param id 编号
     * @param tag 标签
     */
    @Update("update file set tag=#{tag} where id=#{id}")
    void updateTagById(@Param("id") int id, @Param("tag") String tag);

    /**
     * 更新文件分类
     *
     * @param id 编号
     * @param categoryId 分类编号
     */
    @Update("update file set category_id=#{categoryId} where id=#{id}")
    void updateCategoryById(@Param("id") int id, @Param("categoryId") int categoryId);

    /**
     * 获取文件信息
     *
     * @param visitUrl 访问链接
     *
     * @return {@link File}
     */
    @Select("select * from file where visit_url=#{visitUrl}")
    File getFileByVisitUrl(String visitUrl);
}