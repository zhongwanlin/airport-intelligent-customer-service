package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AspInfo {
    
    @JsonProperty("title")
    private String title;

    @JsonProperty("e_title")
    private String enTitle;

    @JsonProperty("url")
    private String url;
}
