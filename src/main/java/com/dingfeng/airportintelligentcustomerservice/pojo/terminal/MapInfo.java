package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapInfo {
    @JsonProperty("gate_map")
    private String gateMap;

    @JsonProperty("e_gate_map")
    private String enGateMap;

    @JsonProperty("pickup_map")
    private String pickupMap;

    @JsonProperty("e_pickup_map")
    private String enPickupMap;

    @JsonProperty("counter_map")
    private String counterMap;

    @JsonProperty("e_counter_map")
    private String enCounterMap;
}
