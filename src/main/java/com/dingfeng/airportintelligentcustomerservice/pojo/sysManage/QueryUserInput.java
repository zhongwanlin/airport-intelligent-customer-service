package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryUserInput extends PageInput {

    /**
     * 部门
     */
    private Integer orgid;

    private String username;

    private String nickname;

    private String mobile;

    private Integer status;

    private Integer roleid;

    private List<Integer> orgIds;
}
