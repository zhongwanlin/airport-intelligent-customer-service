package com.dingfeng.airportintelligentcustomerservice.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    Map<String, Object> uploadPicture(MultipartFile file)throws Exception;
}
