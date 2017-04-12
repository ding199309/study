/** 
 * Project Name:springboot-learn-demo1 
 * File Name:City.java 
 * Package Name:com.spring.springboot.model 
 * Date:2017年4月12日下午3:07:28 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.model;  
/** 
 * ClassName:City <br/> 
 * Function: 城市. <br/> 
 * Date:     2017年4月12日 下午3:07:28 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */

//城市
public class City {	
	 /**
     * 城市编号
     */
    private Long id;
    /**
     * 省份编号
     */
    private Long provinceId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 描述
     */
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", provinceId=" + provinceId + ", cityName=" + cityName + ", description="
				+ description + "]";
	}
    
    

}
  