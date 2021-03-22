package com.ywst.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法级安全验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    /**
     * 指定加密方式
     * @return
     */

   @Bean
   public PasswordEncoder passwordEncoder(){
       // 使用BCrypt加密密码
       return new BCryptPasswordEncoder();
   }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 从数据库读取的用户进行身份认证
        auth.userDetailsService(myUserDetailsService)
        .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                .antMatchers("/list","/index.html","/error.html")
                .permitAll() // 访问静态资源，而无需认证
                .antMatchers("/admin")    // 给资源分配权限
                .hasAnyRole("admin")
                .anyRequest()
                .authenticated() // 所有请求都需要验证
                .and()
                .formLogin() // 使用默认的登录页面
                .loginPage("/index.html")
                .defaultSuccessUrl("/main")   //登陆成功页面
                .failureUrl("/index.html")         //登陆失败页面，重新登陆
                .loginProcessingUrl("/to/login")      //提交登陆表单
                .and()
                .logout()
                .logoutUrl("/to/logout")
                .logoutSuccessUrl("/index.html")     //登出成功页面
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error.html")  //访问被拒绝后前往的页面
                .and()
                .csrf()
                .disable();// post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数

    }

}
