package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationInput extends BaseDto {
    private int pid;
    private String name;
    private String fullname;
}
