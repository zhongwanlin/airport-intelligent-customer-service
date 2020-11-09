package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleInfo {
    private int id;
    private int pid;
    private String pname;
    private String name;
    private String description;
    private String menu_auth;
    private int status;
    private Date create_time;
    private Date update_time;
}
