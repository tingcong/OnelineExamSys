package com.tc.service;

import com.tc.entity.User;
import com.tc.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by htc on 2017/4/18.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询账户数量
     * @param userParam
     * @return
     */
    public int getUserNum(User userParam){
        return userMapper.getUserNum(userParam);
    }

    /**
     * 根据账户密码查询账号信息
     * @param userParam
     * @return
     */
    public User getUserInfoByAccount(User userParam){
        return userMapper.getUserInfoByAccount(userParam);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    public int updatePwd(User user){
        return userMapper.updatePwd(user);
    }
}
