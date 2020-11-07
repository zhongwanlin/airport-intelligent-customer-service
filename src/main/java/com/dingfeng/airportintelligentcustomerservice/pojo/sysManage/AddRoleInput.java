package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoleInput {
    private int pid;
    private String name;
    private String description;
    private String menu_auth;

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
