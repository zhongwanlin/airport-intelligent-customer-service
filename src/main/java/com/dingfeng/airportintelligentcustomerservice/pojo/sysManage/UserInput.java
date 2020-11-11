package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput {
    private int id;
    private String username;
    private String nickname;
    private String password;
    private String mobile;
    private String email;
    private int orgid;
    private int roleid;

}
