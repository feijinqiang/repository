package com.shanghaiyudao.user;

import com.shanghaiyudao.user.module.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    List<UserInfo> queryAll(Map<String, Object> map);

    UserInfo selectUsername(String username);
}