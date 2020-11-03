package com.dingfeng.airportintelligentcustomerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "com.dingfeng")
public class ApiUrlConfig {

    private String baiduVoiceApi;

    private String flightQueryApi;
}
