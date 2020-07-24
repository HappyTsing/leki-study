package com.wang.utils;
/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
public class MyTransactionManager {

    private MyConnectionUtils myConnectionUtils;

    public void setMyConnectionUtils(MyConnectionUtils myConnectionUtils) {
        this.myConnectionUtils = myConnectionUtils;
    }

    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            myConnectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public  void commit(){
        try {
            myConnectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            myConnectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
    public  void release(){
        try {
            myConnectionUtils.getThreadConnection().close();//还回连接池中
            myConnectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

