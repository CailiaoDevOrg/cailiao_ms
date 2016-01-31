package com.whut.cailiao.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by niuyang on 16/1/31.
 */
@Configuration
public class DatabaseConfig {

    @Autowired
    private DruidConfig druidConfig;

    /*@Bean
    public DataSource dataSource() {
        *//*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("sql123");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_ms");*//*

    }*/

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        System.out.println(druidConfig.getUrl());
        System.out.println(druidConfig.getPassword());
        sqlSessionFactoryBean.setDataSource(druidConfig.mysqlDataSource());
        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(druidConfig.mysqlDataSource());
    }

}
