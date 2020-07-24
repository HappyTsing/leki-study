package com.wang.withproxycglib;

import com.wang.withproxy.IProduce;

/**
 * 生产者
 */
public class Producer /*implements IProduce  基于子类的动态代理不需要实现接口！*/ {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱："+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
