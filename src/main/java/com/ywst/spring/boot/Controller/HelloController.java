package com.ywst.spring.boot.Controller;

import com.ywst.spring.boot.entity.UserInfo;
import com.ywst.spring.boot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('admin')") // 只能admin角色才能访问该方法
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/logo")
    public String logout2(){
        return "logo";
    }

}
