package com.dingfeng.airportintelligentcustomerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "com.dingfeng.baidu")
public class BaiduConfig {
    private String appId;
    private String apiKey;
    private String secretKey;
    private String groupId;

}
