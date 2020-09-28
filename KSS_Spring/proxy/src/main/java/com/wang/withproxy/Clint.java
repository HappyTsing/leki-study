//https://www.bilibili.com/video/BV1Sb411s7vP?p=53 代码视频！
package com.wang.withproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Clint {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        /**
         * 动态代理
         * 特点：字节码随用随创建
         * 作用：不修改源码的基础上对方法进行增强
         * 分类：
         *      基于接口的动态管理
         *      基于子类的动态管理
         * 本代码采用基于接口的动态管理
         *      设计的类：Proxy
         *      提供者：JDK官方
         * 如何创建代理对象
         *      使用Proxy类中的newProxyInstance方法
         * 创建代理对象的需求
         *      被代理类最少实现一个接口，如果没有则不能使用
         * newProxyInstance的参数：
         *      ClassLoader：类加载器
         *          它是用于加载代理对象字节码的：用于指定被代理对象的类加载器，写法固定！
         *      Class[]：字节码数组
         *          它是用于让代理对象和被代理对象有相同的方法。写法固定！
         *      InvocationHandler：用于提供增强的代码（即代理的附属功能）
         *          它是让我们写如何代理，即代理需要实现哪些功能，我们一般都是写一个该接口的实现类，通常情况下
         *          都是匿名内部类，但不是必须的，此接口的实现类都是谁用谁写！
         *
         */

        IProduce proxyProducer = (IProduce)Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * 方法参数的含义
                     * @param proxy  代理对象的引用
                     * @param method 当前执行的方法
                     * @param args   当前执行方法所需的参数
                     * @return       和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供代理增强的代码
                        Object retuenValue=null;
                        //1. 获取方法执行的参数
                        Float money = (Float) args[0];
                        //2. 判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())) {
                            //代理抽成20%
                            retuenValue= method.invoke(producer,money*0.8f);
                        }
                        else{
                            //代理抽成40%
                            retuenValue=method.invoke(producer,money*0.6f);
                        }
                        return retuenValue;

                    }
                });
        proxyProducer.saleProduct(1000f);
        proxyProducer.afterService(100f);
    }
}
