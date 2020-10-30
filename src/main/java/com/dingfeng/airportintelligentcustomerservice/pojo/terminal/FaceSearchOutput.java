package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaceSearchOutput {
    @JsonProperty("id_card_no")
    private String idCardNo;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("airline")
    private String airline;

    @JsonProperty("airline_num")
    private String airlineNum;

    @JsonProperty("starting")
    private String starting;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("departure_time")
    private String departureTime;

    @JsonProperty("registerTime")
    private String registerTime;

    @JsonProperty("airplane_status")
    private String airplaneStatus;
}
