package com.ywst.spring.boot.mapper;

import com.ywst.spring.boot.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
//spring框架，AOP玩注解
@Transactional(readOnly = true)
public interface EmpMapper {
    List<Emp> selectAll();

}
