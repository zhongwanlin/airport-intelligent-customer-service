package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoiceInput {
    @JsonProperty("content")
    private String content;
    @JsonProperty("sessionId")
    private String sessionId;

    private int flag;
}
