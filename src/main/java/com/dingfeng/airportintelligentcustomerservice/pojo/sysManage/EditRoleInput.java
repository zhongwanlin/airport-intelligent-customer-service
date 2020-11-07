package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditRoleInput {
    private int id;
    private int pid;
    private String name;
    private String description;
    private String menu_auth;

    @JsonIgnore
    private String update_time;

    public String getUpdate_time() {
        if (update_time ==null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
        return update_time;
    }

    public void setUpdate_time(String updateTime) {
        update_time = updateTime;
    }
}
