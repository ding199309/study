/** 
 * Project Name:springboot-learn-demo1 
 * File Name:UserServiceImpl.java 
 * Package Name:com.spring.springboot.service.impl 
 * Date:2017年4月12日下午3:28:53 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.springboot.dao.master.UserMapper;
import com.spring.springboot.dao.slave.CityMapper;
import com.spring.springboot.model.City;
import com.spring.springboot.model.User;
import com.spring.springboot.service.UserService;

/** 
 * ClassName:UserServiceImpl <br/> 
// * Function: TODO 用户serviceimpl. <br/> 
 * Date:     2017年4月12日 下午3:28:53 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */

@Service
public class UserServiceImpl  implements UserService{
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private CityMapper cityMapper;
	
	
	/**
	 * 
	 * findByName:(通过名称查询对象). <br/> 
	 * @author dfz
	 * @param name
	 * @return 
	 * Date:2017年4月12日下午3:29:55 
	 * @since JDK 1.8
	 */
	public User  findByName(String userName){
			User user=userMapper.findByName(userName);
			City city=cityMapper.findByName("河南");
			if(user!=null){
				user.setCity(city);
			}
		return user;
	}

}
  