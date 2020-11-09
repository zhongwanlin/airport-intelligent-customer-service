package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

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
    List<UserInfo> getAll(QueryUserInput query);

    /**
     * 查询用户详情
     * 
     * @param id
     * @return
     */
    UserInfo getById(int id);

    /**
     * 新增用户
     * 
     * @param addUserInput
     */
    int add(UserInput addUserInput);

    /**
     * 修改用户
     * 
     * @param editUserInput
     */
    int edit(UserInput editUserInput);

    /**
     * 禁用用户
     * 
     * @param id
     */
    int disable(int id);

    /**
     * 启用客户信息
     * 
     * @param id
     * @return
     */
    int enable(int id);

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

    /**
     * 用户登录
     * 
     * @param username
     * @param password
     * @return
     */
    UserInfo getUserByToken(String token);

    /**
     * 用户登录超时
     * 
     * @param token
     * @return
     */
    int loginOvertime(String token);

    /**
     * 新增token
     * 
     * @param token
     * @param userId
     * @return
     */
    int addToken(String token, int userId);

    /**
     * 退出登录
     * 
     * @param token
     * @return
     */
    int loginOut(String token);

    /**
     * 用户登录更新token
     * 
     * @param token
     * @param userId
     * @return
     */
    int loginToken(String token, int userId);
}
