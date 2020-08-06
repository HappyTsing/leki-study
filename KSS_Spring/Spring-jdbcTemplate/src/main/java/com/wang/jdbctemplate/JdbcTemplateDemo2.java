package com.wang.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 基于ioc的配置的Jt简单实现
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemple",JdbcTemplate.class);
        //3. 执行操作
        jt.execute("insert into account(name,money)values ('ddd',2000)");

        //准备数据源
       /* DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=GMT&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("081008");

        //1.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源
        jdbcTemplate.setDataSource(ds);
        //2.执行方法
        jdbcTemplate.execute("insert into account(name,money)values ('ccc',1000)");*/
    }
}
