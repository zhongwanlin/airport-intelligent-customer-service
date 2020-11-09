package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.PageInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryMachineInput extends PageInput {
    private String name;
    private String mac_id;
    private Integer area_id;
    private Integer dep_status;
    private String version;
    private Integer status;
}
