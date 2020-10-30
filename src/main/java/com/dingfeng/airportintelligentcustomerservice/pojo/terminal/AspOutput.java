package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AspOutput {
    @JsonProperty("type")
    private int type;

    @JsonProperty("data")
    private AspInfo data;
}
