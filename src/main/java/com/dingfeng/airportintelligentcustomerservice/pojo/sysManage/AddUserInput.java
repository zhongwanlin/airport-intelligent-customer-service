package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserInput {
    private String username;
    private String nickname;
    private String password;
    private String mobile;
    private String email;
    @JsonIgnore
    private String create_time;

    public String getCreate_time() {
        if (create_time ==null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
        return create_time;
    }

    public void setCreate_time(String createTime) {
        create_time = createTime;
    }
}
