package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Version {

    @JsonProperty("version")
    private String version;

    @JsonProperty("md5")
    private String md5;

    @JsonProperty("url")
    private String url;

    @JsonProperty("update_time")
    private Integer updateTime;
}
