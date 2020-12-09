package com.dingfeng.airportintelligentcustomerservice.pojo.PekApp;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FltPlaceCondRst {
    private List<PekFilghtInfo> pageList;
    private int pageNo;
    private int pageSize;
    private int totalCount;

}
