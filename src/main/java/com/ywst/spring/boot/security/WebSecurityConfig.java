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
                .antMatchers("/list","/index.html").permitAll() // 允许post请求/add-user，而无需认证
                .anyRequest().authenticated() // 所有请求都需要验证
                .and()
                .formLogin() // 使用默认的登录页面
                .loginPage("/login")
                .defaultSuccessUrl("/main")   //登陆成功页面
                .failureUrl("/index.html")         //登陆失败页面，重新登陆
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index.html")     //登出成功页面
                .permitAll()
                .and()
                .csrf().disable();// post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
       //放行静态资源
        web.ignoring().antMatchers("**/**.html");
    }
}
