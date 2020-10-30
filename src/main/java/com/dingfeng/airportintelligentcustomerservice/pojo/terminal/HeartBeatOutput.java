package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartBeatOutput {
    
    /*下次⼼跳间隔，单位时间为秒*/
    @JsonProperty("heart_beat")
    private Integer heartBeat;

    /*从有⼈脸到没⼈脸切换的延 时，单位秒*/
    @JsonProperty("face_change_time")
    private Integer faceChangeTime;

    @JsonProperty("version")
    private Version version;

    @JsonProperty("other_config")
    private String otherConfig;
}
