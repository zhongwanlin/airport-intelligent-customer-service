package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.dingfeng.airportintelligentcustomerservice.config.FileMessageProperties;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.service.FileService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMessageProperties config; // 用来获取file-message.properties配置文件中的信息

    @Override
    public Result uploadFile(MultipartFile file) throws Exception {
        try {
            // 获得文件类型
            String fileName = file.getOriginalFilename();

            // 年月日文件夹
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String basedir = sdf.format(new Date());
            String path = "";

            path = config.getUpPath() + "/" + basedir + "/" + fileName;
            // 如果目录不存在则创建目录
            File uploadFile = new File(path);
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            file.transferTo(uploadFile);
            // 显示路径
            return Result.Success("上传成功", "/api/file/" + basedir + "/" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

}
