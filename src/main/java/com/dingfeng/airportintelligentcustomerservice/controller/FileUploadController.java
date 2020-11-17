package com.dingfeng.airportintelligentcustomerservice.controller;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/upload", description = "文件上传管理接口")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "文件上传(无压缩)", notes = "")
    @ApiParam
    @RequestMapping(value = "/upload/file", method = RequestMethod.POST)
    @ResponseBody
    public Result fileUpload(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        return fileService.uploadFile(file);
    }
}
