package com.shanghaiyudao.user.imp;

import com.shanghaiyudao.user.UserInfoService;
import com.shanghaiyudao.user.dao.UserInfoDao;
import com.shanghaiyudao.user.module.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo selectUsername(String username) {
        return userInfoDao.selectUserInfoByUsername(username);
    }
    @Override
    public List<UserInfo> queryAll(Map<String, Object> map) {
        List<UserInfo> userInfoList = userInfoDao.selectByMap(map);
        return userInfoList;
    }
}
