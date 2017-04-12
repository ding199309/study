/** 
 * Project Name:springboot-learn-demo1 
 * File Name:UserMapper.java 
 * Package Name:com.spring.springboot.dao.master 
 * Date:2017年4月12日下午3:12:55 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.dao.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.springboot.model.User;

/** 
 * ClassName:UserMapper <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:     2017年4月12日 下午3:12:55 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */

@Mapper
public interface UserMapper {
	
	
    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User findByName(@Param("userName") String userName);
}
  