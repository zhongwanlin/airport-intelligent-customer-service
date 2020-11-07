package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AddUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.EditUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.LoginInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.QueryUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.UserInfo;
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
     * @param addUserInput
     * @return
     */
    Result add(AddUserInput addUserInput);

    /**
     * 修改客户信息
     * 
     * @param editUserInput
     * @return
     */
    Result edit(EditUserInput editUserInput);

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
