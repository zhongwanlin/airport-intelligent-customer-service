package com.dingfeng.airportintelligentcustomerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix="file.message")
@PropertySource("classpath:file-message.properties")
public class FileMessageProperties {

    private long fileSize;  //压缩大小

    private double scaleRatio; //压缩比例

    private String upPath; //保存路径

    private String imageType; //图片类型

}
