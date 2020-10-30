package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AspInput {
    
    @JsonProperty("content")
    private String content;
}
