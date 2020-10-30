package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportServiceArticleInput {
    
    /*内容ID*/
    @JsonProperty("article_id")
    private int articleId;

    /*栏目*/
    @JsonProperty("c_id")
    private int columnId;
}
