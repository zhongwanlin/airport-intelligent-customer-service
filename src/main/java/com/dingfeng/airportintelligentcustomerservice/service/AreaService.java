package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaInfo;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaPageInput;
import com.github.pagehelper.PageInfo;

public interface AreaService {
    PageInfo<AreaInfo> getAll(AreaPageInput query);
}
