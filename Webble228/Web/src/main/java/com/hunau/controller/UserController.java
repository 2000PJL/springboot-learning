package com.hunau.controller;

import com.hunau.entity228.User;
import com.hunau.service228.impl.UserServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TanXY
 */
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @PostMapping("/register")
    @ResponseBody
    public String userRegister(HttpServletRequest request) {
        String loginName = request.getParameter("loginName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String salt = userService.randomSalt(6);
        Md5Hash md5Hash = new Md5Hash(password, salt);

        password = md5Hash.toString();

        if (userService.selectUserByName(loginName) == null) {
            if (userService.addUser(new User(loginName, username, salt, password)) == 1) {
                return "success";
            } else {
                return "error";
            }
        } else {
            return "fail";
        }

    }
}
