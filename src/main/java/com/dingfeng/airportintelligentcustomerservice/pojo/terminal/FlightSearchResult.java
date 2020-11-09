package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightSearchResult {

    @JsonProperty("data")
    private List<FlightInfo> data;

    @JsonProperty("error_msg")
    private String error_msg;

    @JsonProperty("error_no")
    private int error_no;

    @JsonProperty("request_id")
    private String request_id;
}
