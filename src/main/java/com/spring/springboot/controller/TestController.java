/** 
 * Project Name:springboot-learn-demo1 
 * File Name:TestController.java 
 * Package Name:com.spring.springboot.controller 
 * Date:2017年4月12日下午3:23:33 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spring.springboot.model.User;
import com.spring.springboot.service.UserService;

/** 
 * ClassName:TestController <br/> 
 * Function: 测试类. <br/> 
 * Date:     2017年4月12日 下午3:23:33 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */

@Controller
public class TestController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/test")
	public void  select(HttpServletResponse rsp,@RequestParam(name="name",required=true)String name) throws IOException{
		User user=userService.findByName(name);
		
		rsp.setContentType("text/html;charset=utf-8");
		rsp.setCharacterEncoding("UTF-8");
		
		PageInfo<User> page=userService.findByDescription("a");
		List<User> list=page.getList();
		for(User users:list){
			System.out.println(users.getUserName());
		}
		rsp.getWriter().print(user);
	}
	
	@RequestMapping("/")
    @ResponseBody
    String home() { 
        return "Hello World!";
    }
}
  