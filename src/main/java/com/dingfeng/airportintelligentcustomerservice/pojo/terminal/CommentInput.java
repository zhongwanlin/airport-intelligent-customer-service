package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentInput {
    
    /*评论内容*/
    @JsonProperty("info")
    private String info;

    /*环境评价*/
    @JsonProperty("environment")
    private String environment;

    /*服务评论*/
    @JsonProperty("service")
    private String service;
}
