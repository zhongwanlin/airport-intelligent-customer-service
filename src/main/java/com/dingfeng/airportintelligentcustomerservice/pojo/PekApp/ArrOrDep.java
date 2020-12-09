package com.dingfeng.airportintelligentcustomerservice.pojo.PekApp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArrOrDep {
    private List<PekFilghtInfo> dataList;
    private int dataSize;
    @JsonProperty("A_OR_D")
    private String A_OR_D;
}
