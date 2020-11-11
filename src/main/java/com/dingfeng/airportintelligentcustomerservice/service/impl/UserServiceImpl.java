package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.UserMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.OrganizationService;
import com.dingfeng.airportintelligentcustomerservice.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrganizationService organizationService;

    @Override
    public PageInfo<UserInfo> getList(QueryUserInput query) {
        if (query.getOrgid() != null) {

            List<Integer> orgIds = new ArrayList<Integer>();
            orgIds.add(query.getOrgid());
            orgIds.addAll(organizationService.getOrgChildIds(query.getOrgid()));
            query.setOrgIds(orgIds);
        }

        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<UserInfo> userInfos = userMapper.getList(query);
        return new PageInfo<>(userInfos);
    }

    @Override
    public Result add(UserInput addUserInput) {

        if (addUserInput == null) {
            return Result.Error("参数为空");
        }
        if (addUserInput.getUsername() == "") {
            return Result.Error("用户名不能为空");
        }
        if (userMapper.exitUserName(addUserInput.getUsername(), 0) > 0) {
            return Result.Error("用户名" + addUserInput.getUsername() + "已存在");
        }

        if (userMapper.add(addUserInput) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(UserInput editUserInput) {
        if (editUserInput == null) {
            return Result.Error("参数为空");
        }
        if (editUserInput.getUsername() == "") {
            return Result.Error("用户名不能为空");
        }
        if (userMapper.exitUserName(editUserInput.getUsername(), editUserInput.getId()) > 0) {
            return Result.Error("用户名" + editUserInput.getUsername() + "已存在");
        }

        if (userMapper.edit(editUserInput) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    @Override
    public Result disable(int id) {
        if (userMapper.disable(id) > 0) {
            return Result.Success("禁用成功");
        }
        return Result.Error("禁用失败，没找到客户信息");
    }

    @Override
    public Result enable(int id) {
        if (userMapper.enable(id) > 0) {
            return Result.Success("启用成功");
        }
        return Result.Error("启用失败，没找到客户信息");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result login(LoginInput loginInput) {
        try {
            UserInfo user = userMapper.login(loginInput);
            if (user != null) {
                // 生成token
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                userMapper.loginToken(token, user.getId());
                userMapper.addToken(token, user.getId());
                user.setToken(token);
                return Result.Success("登录成功", user);
            }
            return Result.Error("用户名或密码错误");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result getById(int id) {
        UserInfo user = userMapper.getById(id);
        if (user != null) {
            return Result.Success("查询成功", user);
        }
        return Result.Error("查询没有数据");
    }

    @Override
    public UserInfo getUser(String token) {
        return userMapper.getUserByToken(token);
    }

    @Override
    public boolean isLoginOvertime(String token) {
        return userMapper.loginOvertime(token) <= 0;
    }

    @Override
    public Result loginOut(String token) {
        userMapper.loginOut(token);

        return Result.Success("退出登录成功");
    }
}
