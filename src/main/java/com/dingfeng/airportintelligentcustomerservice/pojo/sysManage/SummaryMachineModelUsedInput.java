package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.PageInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SummaryMachineModelUsedInput extends PageInput {
    private String mac_id;
    private String area_name;
    private String mac_model_id;
    private String begDate;
    private String endDate;
}
