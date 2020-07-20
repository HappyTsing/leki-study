package com.wang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IndexTest {
    public static void main(String[] args) {
        //    获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //        Index index = (Index) context.getBean("index");
        //         getBean的参数是beans.xml中的id值
        Service service = (Service) context.getBean("service");


    }


}
