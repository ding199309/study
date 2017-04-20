package com.spring.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年4月20日 下午3:15:04 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

@Controller
@RequestMapping("/admin")
public class IndexController {
	static final String PATH="admin/";
	
	
	@RequestMapping("/login")
	public String login(){
		
				
		return PATH+"login";
	}

}
