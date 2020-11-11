package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 文件上传
     * 
     * @param file
     * @return
     * @throws Exception
     */
    Result uploadFile(MultipartFile file) throws Exception;
}
