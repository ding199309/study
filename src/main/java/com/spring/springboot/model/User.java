/** 
 * Project Name:springboot-learn-demo1 
 * File Name:User.java 
 * Package Name:com.spring.springboot.model 
 * Date:2017年4月12日下午3:09:47 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.model;
/** 
 * ClassName:User <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:     2017年4月12日 下午3:09:47 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */

//用户表
public class User {
	
	/**
     * 城市编号
     */
    private Long id;
    /**
     * 城市名称
     */
    private String userName;

    /**
     * 描述
     */
    private String description;
    
    private City city;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", description=" + description + ", city=" + city + "]";
	}
}
  