package com.tc.mapper;

import com.tc.entity.User;

/**
 * Created by htc on 2017/4/18.
 */
public interface UserMapper {

    //查询用户数量
    int getUserNum(User user);

    //根据账号密码查询用户信息
    User getUserInfoByAccount(User userParam);

    //修改用户密码
    int updatePwd(User user);
}
