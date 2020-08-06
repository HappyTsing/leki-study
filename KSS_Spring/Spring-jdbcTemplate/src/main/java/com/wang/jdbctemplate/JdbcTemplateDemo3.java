package com.wang.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

/**
 * 基于ioc的配置的Jt实现CRUD
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {


        //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemple",JdbcTemplate.class);
        //3. 执行操作
//        jt.query
//        jt.execute("insert into account(name,money)values ('ddd',2000)");

    }
}
