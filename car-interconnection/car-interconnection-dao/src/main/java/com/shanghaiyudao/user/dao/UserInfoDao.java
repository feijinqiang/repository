package com.shanghaiyudao.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanghaiyudao.user.module.UserInfo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {
    UserInfo selectUserInfoByUsername(String username);
}
