package com.ywst.spring.boot.Controller;

import com.ywst.spring.boot.entity.Emp;
import com.ywst.spring.boot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    //springmvc框架，玩注解
    //输出数据库的数据
    @RequestMapping("/list/emp")
    @ResponseBody
    public List<Emp> list(){
        return empService.getAll();
    }

    //springmvc框架，玩注解。跳转视图页面
    @RequestMapping("/common")
    public String common(Model model){

        model.addAttribute("attrName","Hello World!");
        return "common";
    }

    //输出字符串到页面
    @RequestMapping("/page")
    @ResponseBody
    public String page(){
        return "This is a Page.";
    }

}
