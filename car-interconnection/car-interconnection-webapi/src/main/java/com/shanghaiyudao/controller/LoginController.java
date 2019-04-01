package com.shanghaiyudao.controller;


import com.shanghaiyudao.entity.Result;
import com.shanghaiyudao.user.UserInfoService;
import com.shanghaiyudao.user.module.UserInfo;


import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @auther: fjq
 * @2019/3/25 11:10
 * @description: 用于处理用户登陆相关请求
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("/login")
    public Result login(String username, String password, HttpSession session) {
        if(!StringUtils.isEmpty(username)&!StringUtils.isEmpty(username)){
            UserInfo userInfo = userInfoService.selectUsername(username);
            //用户账号密码正确，跳转成功页面，并将用户信息保存到session
            if(password.equals(userInfo.getPassword())){
                session.setAttribute("loginUser",userInfo);
                return Result.getSuccessResult(userInfo);
            }
            return Result.failResult();
        }
        return Result.failResult();
    }
}
