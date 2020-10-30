package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoiceOutput {
    
    @JsonProperty("action")
    private String action;

    @JsonProperty("reply_content")
    private String replyContent;

    @JsonProperty("action_data")
    private VoiceActionDataInfo actionData;
}
