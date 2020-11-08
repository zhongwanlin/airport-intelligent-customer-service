package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import com.github.pagehelper.PageInfo;

public interface UserService {

    /**
     * 用户列表查询
     * 
     * @param query
     * @return
     */
    PageInfo<UserInfo> getAllUser(QueryUserInput query);

    /**
     * 查询用户详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增客户
     * 
     * @param userInput
     * @return
     */
    Result add(UserInput userInput);

    /**
     * 修改客户信息
     * 
     * @param userInput
     * @return
     */
    Result edit(UserInput userInput);

    /**
     * 删除客户信息
     * 
     * @param id
     * @return
     */
    Result delete(int id);

    /**
     * 用户登录
     * 
     * @param loginInput
     * @return
     */
    Result login(LoginInput loginInput);
}
