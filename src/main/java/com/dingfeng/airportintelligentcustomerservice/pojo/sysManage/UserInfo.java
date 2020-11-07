package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("用户")
public class UserInfo {
    private int id;
    private int b_id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private int email_bind;
    private String mobile;
    private int mobile_bind;
    private int avatar;
    private BigDecimal money;
    private int score;
    private int role;
    private int group;
    private BigInteger signup_ip;
    private Date create_time;
    private Date update_time;
    private Date last_login_time;
    private int sort;
    private int status;
    private String rolename;
}
