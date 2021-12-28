package com.hunau.service228.impl;

import com.hunau.entity228.User;
import com.hunau.mapper228.UserMapper;
import com.hunau.service228.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 10:56
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByName(String loginName) {
        return userMapper.selectUserByName(loginName);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public String randomSalt(int len) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
