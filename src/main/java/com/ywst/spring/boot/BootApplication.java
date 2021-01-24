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

        //spring框架，IOC容器获取对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(applicationContext.getBean("emp"));

        System.out.println("系统已经成功启动！");


        //springboot打成war包步骤：
        //1.application修改如下代码：新加@ServletComponentScan注解，并且继承SpringBootServletInitializer
        //2.pom.xml修改为如下代码，主要两个改动：新加打包成war的声明： <packaging>war</packaging>
        //3.项目目录下执行命令生成war包，mvn clean package


    }

}
