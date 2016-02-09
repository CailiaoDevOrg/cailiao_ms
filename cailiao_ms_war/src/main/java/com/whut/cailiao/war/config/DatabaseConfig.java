package com.whut.cailiao.war.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by niuyang on 16/1/31.
 */
@Configuration
@MapperScan("com.whut.cailiao.dao")
public class DatabaseConfig {

    @Autowired
    private DruidConfig druidConfig;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidConfig.mysqlDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(druidConfig.mysqlDataSource());
    }

}
