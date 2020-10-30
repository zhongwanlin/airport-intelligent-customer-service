package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoiceActionDataInfo {
    
    @JsonProperty("conversation_id")
    private String conversationId;

    @JsonProperty("jump_url")
    private String jumpUrl;

    @JsonProperty("text")
    private String text;
}
