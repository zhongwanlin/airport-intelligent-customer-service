package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput extends BaseDto {
    private String username;
    private String nickname;
    private String password;
    private String mobile;
    private String email;

}
