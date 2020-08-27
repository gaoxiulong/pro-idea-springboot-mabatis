package com.ywst.spring.boot.Controller;

import com.ywst.spring.boot.entity.Emp;
import com.ywst.spring.boot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/ListEmp")
    @ResponseBody
    public List<Emp> list(){
        return empService.getAll();
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
