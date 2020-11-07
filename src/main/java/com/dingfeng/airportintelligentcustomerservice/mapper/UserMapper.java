package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AddUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.EditUserInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.LoginInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.UserInfo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface UserMapper {

    /**
     * 查询用户信息
     * 
     * @return
     */
    List<UserInfo> getAll();

    /**
     * 新增用户
     * 
     * @param addUserInput
     */
    int add(AddUserInput addUserInput);

    /**
     * 修改用户
     * 
     * @param editUserInput
     */
    int edit(EditUserInput editUserInput);

    /**
     * 删除用户
     * 
     * @param id
     */
    int delete(int id);

    /**
     * 用户名是否存在
     * 
     * @param username
     * @return
     */
    int exitUserName(String username, int id);

    /**
     * 用户登录
     * 
     * @param username
     * @param password
     * @return
     */
    UserInfo login(LoginInput loginInput);
}
