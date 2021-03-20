package com.ywst.spring.boot.service;


import com.ywst.spring.boot.entity.UserInfo;
import com.ywst.spring.boot.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String username) {
        return userInfoMapper.getUserInfoByUsername(username);
    }

    @Override
    public List<UserInfo> getUserList() {
        return userInfoMapper.getAll();
    }
}
