/** 
 * Project Name:springboot-learn-demo1 
 * File Name:MainConfig.java 
 * Package Name:com.spring.springboot.config 
 * Date:2017年4月12日下午2:06:00 
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.spring.springboot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

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
    
    @Value("${share.datasource.initialSize}")
    private int initialSize;

    @Value("${share.datasource.minIdle}")
    private int minIdle;

    @Value("${share.datasource.maxActive}")
    private int maxActive;

    @Value("${share.datasource.maxWait}")
    private int maxWait;

    @Value("${share.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${share.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${share.datasource.validationQuery}")
    private String validationQuery;

    @Value("${share.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${share.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${share.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${share.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${share.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${share.datasource.filters}")
    private String filters;

    @Value("{share.datasource.connectionProperties}")
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
        
        // 分页插件 
        PageHelper pageHelper = new PageHelper(); 
        Properties properties = new Properties(); 
        properties.setProperty("reasonable", "true"); 
        properties.setProperty("supportMethodsArguments", "true"); 
        properties.setProperty("returnPageInfo", "check"); 
        properties.setProperty("params", "count=countSql"); 
        pageHelper.setProperties(properties);
        //添加插件
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterConfig.location));
        return sessionFactory.getObject();
    }
    
    
}
  