package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleInput {
    private int id;
    private int pid;
    private String name;
    private String description;
    private String menu_auth;

}
