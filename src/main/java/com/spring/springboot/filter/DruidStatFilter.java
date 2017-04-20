package com.spring.springboot.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import com.alibaba.druid.support.http.WebStatFilter;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年4月19日 下午4:53:14 
* @version 1.0   这里要写filter，配合druid监控的使用。
* @parameter  
* @since  
* @return  
*/

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",  
initParams={  
         @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源  
 }  
) 
public class DruidStatFilter extends WebStatFilter{  
	  
} 