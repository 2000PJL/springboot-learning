package com.iot.domain;

import lombok.Data;

/**
 * @ClassName: User
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 10:24
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
 */
@Data
public class User {

    private int userId;

    private String loginName;

    private String username;

    private String salt;

    private String password;

    private String delFlag;

    public User(String loginName, String username, String salt, String password) {
        this.loginName = loginName;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.delFlag = "0";
    }
}
