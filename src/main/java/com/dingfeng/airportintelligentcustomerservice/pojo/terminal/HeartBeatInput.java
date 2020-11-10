package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartBeatInput {

    /**/
    @JsonProperty("version")
    private String version;

    @JsonIgnore
    private String body;

    @JsonIgnore
    private String mac_id;

    @JsonProperty("basic_info")
    private String div_info;

    @JsonProperty("basic_status")
    private String div_status;
}
