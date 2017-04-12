/** 
 * Project Name:springboot-learn-demo1 
 * File Name:UserService.java 
 * Package Name:com.spring.springboot.service 
 * Date:2017年4月12日下午3:28:21 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.service;

import com.spring.springboot.model.User;

/** 
 * ClassName:UserService <br/> 
 * Date:     2017年4月12日 下午3:28:21 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */


public interface UserService {

	/**
	 * 
	 * findByName:(通过名称查询对象). <br/> 
	 * @author dfz
	 * @param name
	 * @return 
	 * Date:2017年4月12日下午3:29:55 
	 * @since JDK 1.8
	 */
	User  findByName(String name);
}
  