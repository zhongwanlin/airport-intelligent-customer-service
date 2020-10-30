package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartBeatInput {
    
    /**/
    @JsonProperty("version")
    private String version;

    @JsonProperty("basic_info")
    private String basicInfo;

    @JsonProperty("basic_status")
    private String basicStatus;
}
