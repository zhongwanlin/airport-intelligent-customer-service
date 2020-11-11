package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.PageInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryMachineSdkLogInput extends PageInput {
    private String area_name;
    private String mac_id;
    private String mac_model_id;
    private String begDate;
    private String endDate;
}
