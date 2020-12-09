package com.dingfeng.airportintelligentcustomerservice.pojo.PekApp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FtNoCondNewRst {
    @JsonProperty("ARR")
    private ArrOrDep ARR;
    @JsonProperty("DEP")
    private ArrOrDep DEP;
}
