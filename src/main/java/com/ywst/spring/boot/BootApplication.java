package com.ywst.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        //springboot框架
        SpringApplication.run(BootApplication.class, args);

        //spring框架
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(applicationContext.getBean("emp"));
    }

}
