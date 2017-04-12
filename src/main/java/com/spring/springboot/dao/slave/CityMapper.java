/** 
 * Project Name:springboot-learn-demo1 
 * File Name:CityMapper.java 
 * Package Name:com.spring.springboot.dao.slave 
 * Date:2017年4月12日下午3:14:01 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.dao.slave;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.spring.springboot.model.City;

/** 
 * ClassName:CityMapper <br/> 
// * Function: 城市. <br/> 
 * Date:     2017年4月12日 下午3:14:01 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */

@Mapper
public interface CityMapper {
	
	 /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);

}
  