package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryUserInput extends PageInput {

    /**
     * 部门
     */
    private List<Integer> orgIds;

    private String username;

    private String nickname;

    private String mobile;

    private Integer status;
}
