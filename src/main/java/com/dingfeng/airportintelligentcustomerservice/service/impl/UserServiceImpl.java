package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.mapper.UserMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.QueryUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.UserInfo;
import com.dingfeng.airportintelligentcustomerservice.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<UserInfo> getAllUser(QueryUserInput query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<UserInfo> userInfos = userMapper.getAll();
        return new PageInfo<>(userInfos);
    }
}
