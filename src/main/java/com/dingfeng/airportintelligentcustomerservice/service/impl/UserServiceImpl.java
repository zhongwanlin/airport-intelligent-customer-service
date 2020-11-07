package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.UserMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AddUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.EditUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.LoginInput;
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
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<UserInfo> userInfos = userMapper.getAll(query);
        return new PageInfo<>(userInfos);
    }

    @Override
    public Result add(AddUserInput addUserInput) {

        if (addUserInput == null) {
            return Result.Error("参数为空");
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
    public Result edit(EditUserInput editUserInput) {
        if (editUserInput == null) {
            return Result.Error("参数为空");
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
    public Result delete(int id) {
        if (userMapper.delete(id) > 0) {
            return Result.Success("删除成功");
        }
        return Result.Error("删除失败");
    }

    @Override
    public Result login(LoginInput loginInput) {
        UserInfo user = userMapper.login(loginInput);
        if (user != null) {
            return Result.Success("登录成功", user);
        }
        return Result.Error("登录失败");
    }

    @Override
    public Result getById(int id) {
        UserInfo user = userMapper.getById(id);
        if (user != null) {
            return Result.Success("查询成功", user);
        }
        return Result.Error("查询没有数据");
    }
}
