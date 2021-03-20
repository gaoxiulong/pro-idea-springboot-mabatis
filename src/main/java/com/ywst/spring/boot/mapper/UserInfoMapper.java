package com.ywst.spring.boot.mapper;

import com.ywst.spring.boot.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(readOnly = true)
public interface UserInfoMapper {

   // @Select("select * from user where username = #{username}")
    UserInfo getUserInfoByUsername(@Param("username") String username);

    List<UserInfo> getAll();
}
