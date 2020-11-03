package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.UserInfo;
import com.github.pagehelper.PageInfo;

public interface UserService {

    PageInfo<UserInfo> getAllUser();
}
