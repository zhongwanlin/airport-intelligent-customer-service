package com.dingfeng.airportintelligentcustomerservice.controller;

import java.util.HashMap;
import java.util.Map;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.core.Result2;
import com.dingfeng.airportintelligentcustomerservice.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public Result2 setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file) {
        Result2 result = new Result2();
        try {
            Map<String, Object> resultMap = upload(file);
            if (resultMap.get("result") == "SUCCESS") {
                result.setCode("00");
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }
            result.setData(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("99");
            result.setMessage(e.getMessage());
        }
        return result;
    }

    private Map<String, Object> upload(MultipartFile file) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            if (!file.isEmpty()) {
                return fileService.uploadPicture(file);

            } else {
                returnMap.put("result", "fail");
                returnMap.put("msg", "文件为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return returnMap;
    }
}
