/** 
 * Project Name:springboot-learn-demo1 
 * File Name:SlaveConfig.java 
 * Package Name:com.spring.springboot.config 
 * Date:2017年4月12日下午2:09:19 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.pool.DruidDataSource;

/** 
 * ClassName:SlaveConfig <br/> 
 * Function: TODO 从配置源 <br/> 
 * Date:     2017年4月12日 下午2:09:19 <br/> 
 * @author   dfz
 * 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
@MapperScan(basePackages=SlaveConfig.path,sqlSessionFactoryRef="clusterSqlSessionFactory")
public class SlaveConfig {
	// 精确到 slave 目录，以便跟其他数据源隔离
	static final String  path="com.spring.springboot.dao.slave";
	static final String location="classpath:mapper/slave/*.xml";

	  @Value("${slave.datasource.url}")
	    private String url;

	    @Value("${slave.datasource.username}")
	    private String user;

	    @Value("${slave.datasource.password}")
	    private String password;

	    @Value("${slave.datasource.driverClassName}")
	    private String driverClass;

	    @Bean(name = "slaveDataSource")
	    public DataSource slaveDataSource() {
	        DruidDataSource dataSource = new DruidDataSource();
	        dataSource.setDriverClassName(driverClass);
	        dataSource.setUrl(url);
	        dataSource.setUsername(user);
	        dataSource.setPassword(password);
	        return dataSource;
	    }
	    @Bean(name = "clusterTransactionManager")
	    public DataSourceTransactionManager clusterTransactionManager() {
	        return new DataSourceTransactionManager(slaveDataSource());
	    }
	    @Bean(name = "clusterSqlSessionFactory")
	    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource)
	            throws Exception {
	        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(slaveDataSource);
	        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
	                .getResources(SlaveConfig.location));
	        return sessionFactory.getObject();
	    }
}
  