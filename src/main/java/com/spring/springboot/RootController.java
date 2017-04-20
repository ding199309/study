package com.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;


/**
 * 
 * 文件名称为：RootController.java
 * @author dfz
 * @version  1.0.0
 * @time  2017年4月18日 下午3:38:10
 * @copyright Anymusic Ltd.
 */

@SpringBootApplication
@ServletComponentScan   //扫描Servlet 
public class RootController{


//  继承SpringBootServletInitializer   主要是用于发布到tomcat中
//public class RootController  extends SpringBootServletInitializer {
	
// 使用@SpringBootApplication注解。但是如果war包发布至tomcat，需要增加 SpringBootServletInitializer 子类，
// 并覆盖它的 configure 方法，或者直接将main函数所在的类继承 SpringBootServletInitializer 子类，并覆盖它的 configure 方法。
	
//	@Override
//    protected SpringApplicationBuilder configure(
//            SpringApplicationBuilder application) {
//        return application.sources(RootController.class);
//    }
	
	
	
    public static void main(String[] args) throws Exception {
        // 程序启动入口
        SpringApplication.run(RootController.class, args);
    }
}

/**
 *  注解：    
 *   1：发布到tomcat中，首先要变项目为war包，但是如果war包发布至tomcat，需要增加 SpringBootServletInitializer 子类，
 *	  并覆盖它的 configure 方法，或者直接将main函数所在的类继承 SpringBootServletInitializer 子类，并覆盖它的 configure 方法
 *	 2：更改pom.xml，修改 Spring Boot Web 依赖下的排除自身所带的tomcat
 */











