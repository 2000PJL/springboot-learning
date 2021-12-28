package com.hunau.service228;

import com.hunau.entity228.User;

/**
 * @ClassName: UserMapper
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 10:41
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
 */
public interface UserService {

    /**
     * @Author xss
     * @Description //TODO 根据登录名称查询用户，主要用于登录校验
     * @Date 10:42 2021/3/26
     * @Param [loginName]
     * @return com.hunau.entity228.User
     **/
    User selectUserByName(String loginName);

    /**
     * @Author xss
     * @Description //TODO 添加用户，主要用于注册
     * @Date 10:42 2021/3/26
     * @Param [user]
     * @return int
     **/
    int addUser(User user);

    /**
     * @Author xss
     * @Description //TODO 用于用户注册时生产随机盐
     * @Date 10:45 2021/3/26
     * @Param [len]
     * @return java.lang.String
     **/
    String randomSalt(int len);

}
