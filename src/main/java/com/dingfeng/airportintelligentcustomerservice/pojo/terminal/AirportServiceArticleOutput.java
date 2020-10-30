package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportServiceArticleOutput {
    
    /*⽂章ID*/
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("b_id")
    private Integer bId;

    /*中⽂标题*/
    @JsonProperty("title")
    private String title;

    /*英⽂标题*/
    @JsonProperty("e_title")
    private String enTitle;

    /*中⽂内容*/
    @JsonProperty("con")
    private String con;

    /*英⽂内容*/
    @JsonProperty("e_con")
    private String enCon;

    /*链接*/
    @JsonProperty("url")
    private String url;

    /*1内容2链接*/
    @JsonProperty("type")
    private Integer type;

    /*创建时间*/
    @JsonProperty("read_sum")
    private Integer readSum;

    /*修改时间*/
    @JsonProperty("create_time")
    private Integer createTime;

    @JsonProperty("status")
    private Integer status;
}
