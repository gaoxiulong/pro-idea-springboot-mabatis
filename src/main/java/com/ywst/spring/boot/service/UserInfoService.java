package com.ywst.spring.boot.service;

import com.ywst.spring.boot.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

   public UserInfo getUserInfo(String username);

    public List<UserInfo> getUserList();

}
