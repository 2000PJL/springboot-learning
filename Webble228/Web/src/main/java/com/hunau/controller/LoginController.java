package com.hunau.controller;

import com.hunau.service228.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TanXY
 * @create 2020/7/10 - 14:33
 */
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("")
    public String redirectLogin() {
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/toLogin")
    public String login(HttpServletRequest request) {
        String login_name = request.getParameter("loginName");
        String password = request.getParameter("password");

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken(login_name, password);

        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            System.out.println("账号或密码错误");
            return "2";
        } catch (UnknownAccountException e) {
            System.out.println("账号不存在");
            return "3";
        }

        return "1";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
