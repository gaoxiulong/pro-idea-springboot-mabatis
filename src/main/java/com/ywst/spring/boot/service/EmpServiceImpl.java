package com.ywst.spring.boot.service;

import com.ywst.spring.boot.entity.Emp;
import com.ywst.spring.boot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    public List<Emp> getAll() {
        return empMapper.selectAll();
    }
}
