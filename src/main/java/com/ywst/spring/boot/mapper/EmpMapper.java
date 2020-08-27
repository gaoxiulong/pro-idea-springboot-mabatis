package com.ywst.spring.boot.mapper;

import com.ywst.spring.boot.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> selectAll();

}
