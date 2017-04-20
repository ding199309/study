/** 
 * Project Name:springboot-learn-demo1 
 * File Name:MainConfig.java 
 * Package Name:com.spring.springboot.config 
 * Date:2017年4月12日下午2:06:00 
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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/** 
 * ClassName:MainConfig <br/> 
 * Function: TODO 主数据源控制 <br/> 
 * Date:     2017年4月12日 下午2:06:00 <br/> 
 * @author   dfz
 * @version   
 * @since    JDK 1.8 
 * @see       
 */


//主数据源控制 

@Configuration
//扫描 Mapper 接口并容器管理
@MapperScan(basePackages=MasterConfig.path,sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterConfig {
	// 精确到 master 目录，以便跟其他数据源隔离
	static final String  path="com.spring.springboot.dao.master";
	static final String location="classpath:mapper/master/*.xml";
	
    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String user;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClass;
    
    @Value("${master.datasource.initialSize}")
    private int initialSize;

    @Value("${master.datasource.minIdle}")
    private int minIdle;

    @Value("${master.datasource.maxActive}")
    private int maxActive;

    @Value("${master.datasource.maxWait}")
    private int maxWait;

    @Value("${master.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${master.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${master.datasource.validationQuery}")
    private String validationQuery;

    @Value("${master.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${master.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${master.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${master.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${master.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${master.datasource.filters}")
    private String filters;

    @Value("{master.datasource.connectionProperties}")
    private String connectionProperties;
    
    
    @Bean(name = "masterDataSource")
    @Primary //以此为主
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        
      //configuration
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }
    
    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }
    
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterConfig.location));
        return sessionFactory.getObject();
    }
    
    
}
  