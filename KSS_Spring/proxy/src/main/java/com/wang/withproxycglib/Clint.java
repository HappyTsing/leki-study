//https://www.bilibili.com/video/BV1Sb411s7vP?p=53 代码视频！
package com.wang.withproxycglib;

import com.wang.withproxy.IProduce;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         * 本代码采用基于子类的动态管理
         *      设计的类：Enhancer
         *      提供者：第三方cglib库
         * 如何创建代理对象
         *      使用Enhancer类中的create方法
         * 创建代理对象的需求
         *      被代理类不能是最终类（即被代理类不能被finall修饰）
         * create的参数：
         *      Class：类加载器
         *          用于指定被代理对象的字节码，内容固定！
         *      Callback：用于提供增强的代码（即代理的附属功能）
         *          它是让我们写如何代理，即代理需要实现哪些功能，我们一般都是写一个该接口的实现类，通常情况下
         *          都是匿名内部类，但不是必须的，此接口的实现类都是谁用谁写！
         *          一般都是new一个他的子接口的实现类：MethodInterceptor
         */
       Producer cglibProducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 作用：执行被代理对象的任何方法都会经过该方法！
             * 方法参数的含义
             * @param o 相当于基于接口动态代理的proxy，即代理对象的引用
             * @param method  相当于基于接口动态道理的method，即当前执行的方法
             * @param objects  相当于基于接口动态代理的args，即当前执行方法所需要的参数
             *       以上三个参数和基于接口的动态代理中invoke方法的参数是一致的！
             * @param methodProxy  当前执行对象的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供代理增强的代码
                Object returnValue = null;
                //1. 获取方法执行的参数
                Float money = (Float) objects[0];
                //2. 判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    //代理抽成20%
                    System.out.println("经过了动态代理cglib");
                    returnValue= method.invoke(producer,money*0.8f);
                }
                else{
                    //代理抽成40%
                    System.out.println("经过了动态代理cglib");
                    returnValue=method.invoke(producer,money*0.6f);
                }
                return returnValue;
            }

        });
        cglibProducer.saleProduct(1000f);
        cglibProducer.afterService(100f);
    }
}






//
//        /**
//         * 动态代理
//         * 特点：字节码随用随创建
//         * 作用：不修改源码的基础上对方法进行增强
//         * 分类：
//         *      基于接口的动态管理
//         *      基于子类的动态管理
//         * 本代码采用基于接口的动态管理
//         *      设计的类：Proxy
//         *      提供者：JDK官方
//         * 如何创建代理对象
//         *      使用Proxy类中的newProxyInstance方法
//         * 创建代理对象的需求
//         *      被代理类最少实现一个接口，如果没有则不能使用
//         * newProxyInstance的参数：
//         *      ClassLoader：类加载器
//         *          它是用于加载代理对象字节码的：用于指定被代理对象的类加载器，写法固定！
//         *      Class[]：字节码数组
//         *          它是用于让代理对象和被代理对象有相同的方法。写法固定！
//         *      InvocationHandler：用于提供增强的代码（即代理的附属功能）
//         *          它是让我们写如何代理，即代理需要实现哪些功能，我们一般都是写一个该接口的实现类，通常情况下
//         *          都是匿名内部类，但不是必须的，此接口的实现类都是谁用谁写！
//         *
//         */

//        IProduce proxyProducer = (IProduce)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
//                producer.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    /**
//                     * 作用：执行被代理对象的任何接口方法都会经过该方法
//                     * 方法参数的含义
//                     * @param proxy  代理对象的引用
//                     * @param method 当前执行的方法
//                     * @param args   当前执行方法所需的参数
//                     * @return       和被代理对象方法有相同的返回值
//                     * @throws Throwable
//                     */
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        //提供代理增强的代码
//                        Object retuenValue=null;
//                        //1. 获取方法执行的参数
//                        Float money = (Float) args[0];
//                        //2. 判断当前方法是不是销售
//                        if ("saleProduct".equals(method.getName())) {
//                            //代理抽成20%
//                            retuenValue= method.invoke(producer,money*0.8f);
//                        }
//                        else{
//                            //代理抽成40%
//                            retuenValue=method.invoke(producer,money*0.6f);
//                        }
//                        return retuenValue;
//
//                    }
//                });
//        proxyProducer.saleProduct(1000f);
//        proxyProducer.afterService(100f);
