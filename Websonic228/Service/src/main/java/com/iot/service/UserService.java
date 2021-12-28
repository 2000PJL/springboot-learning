package com.iot.service;

import com.iot.domain.User;

/*
 * @Systemname: Websonic228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  9:22 2021/11/22
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
public interface UserService {

    /**
     * @Author PJL
     * @Description //TODO 根据登录名称查询用户，主要用于登录校验
     * @Date 18:42 2021/11/22
     * @Param [loginName]
     * @return com.iot.domain.User
     **/
    User selectUserByName(String loginName);

    /**
     * @Author PJL
     * @Description //TODO 添加用户，主要用于注册
     * @Date 18:42 2021/11/22
     * @Param [user]
     * @return int
     **/
    int addUser(User user);

    /**
     * @Author PJL
     * @Description //TODO 用于用户注册时生产随机盐
     * @Date 10:45 2021/3/26
     * @Param [len]
     * @return java.lang.String
     **/
    String randomSalt(int len);

}
