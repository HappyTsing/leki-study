package com.wang.test;

import com.wang.service.IAccountService;
import com.wang.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
//        IAccountService as =(IAccountService)ac.getBean("accountServiceImpl");
        IAccountService as =ac.getBean("accountServiceImpl",IAccountService.class);

        /**
         *此处如下写法是错误的，原因是Spring动态代理，实现接口用的是JDK的自动代理，此时获取到的对象是基于接口的，因此需要使用
         * 接口对象来进行强制转换，而不实现接口的动态代理采用cglib实现。spring会自动识别jdk proxy还是cglib动态代理
         */
//        AccountServiceImpl as =ac.getBean("accountServiceImpl",AccountServiceImpl.class);

        //执行方法
        as.saveAccount();
    }
}
