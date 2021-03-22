package com.ywst.spring.boot.Controller;

import com.ywst.spring.boot.entity.UserInfo;
import com.ywst.spring.boot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    UserInfoService userInfoService;

    @ResponseBody
    @GetMapping("/get")
    public UserInfo getUser(@RequestParam String username){
        return userInfoService.getUserInfo(username);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<UserInfo> getUserList(){
        return userInfoService.getUserList();
    }


    @PreAuthorize("hasAnyRole('user')") // 只能user角色才能访问该方法
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    //@PreAuthorize("hasAnyRole('admin')") // 只能admin角色才能访问该方法
    @GetMapping("/admin")
    //@ResponseBody   //页面展示字符串时需要注解
    public String admin(){
       // return "具备admin权限";
        return "admin";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

/*    @GetMapping("/index")
    public String index(){
        return "index";
    }*/

    @GetMapping("/get/user")
    @ResponseBody
    public String getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserInfo userInfo = userInfoService.getUserInfo(name);
        int id = userInfo.getId();
        return "Name：" + name + " ，Id：" +id;
    }


}
