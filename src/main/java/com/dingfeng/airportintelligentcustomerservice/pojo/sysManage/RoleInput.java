package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleInput extends BaseDto {
    private int pid;
    private String name;
    private String description;
    private String menu_auth;

}
