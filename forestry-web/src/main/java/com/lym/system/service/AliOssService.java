package com.lym.system.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author NieChangan
 */
public interface AliOssService {

    /**
     * 创建存储空间
     */
    void createBucket();

    /**
     * 上传文件
     * @param file 文件对象
     * @return
     */
    String upload(MultipartFile file);

    /**
     * 下载文件
     * @throws IOException
     */
    void download(String fileName) throws IOException;

    /**
     * 列举文件
     */
    void listFile();

    /**
     * 删除文件
     */
    void deleteFile(String fileName);


}