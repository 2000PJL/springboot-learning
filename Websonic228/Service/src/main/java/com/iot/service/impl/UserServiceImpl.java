package com.iot.service.impl;

import com.iot.domain.User;
import com.iot.mapper.UserMapper;
import com.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/*
 * @Systemname: Websonic228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  9:22 2021/11/22
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
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
