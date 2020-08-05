package com.wang.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法
     */

    //前置通知
    public void beforePrintLog() {
        System.out.println("前置通知：function beforePrintLog in Logger Class is performing!");
    }
    //后置通知
    public void afterReturningPrintLog() {
        System.out.println("后置通知：function afterReturningPrintLog in Logger Class is performing!");
    }
    //异常通知
    public void afterThrowingPrintLog() {
        System.out.println("异常通知：unction afterThrowingPrintLog in Logger Class is performing!");
    }

    //最终通知
    public void afterPrintLog() {
        System.out.println("最终通知：function afterPrintLog in Logger Class is performing!");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      Spring框架为我们提供一个接口：ProceedingJoinPoint。该接口有一个方法 proceed()，此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时， spring框架会为我们提供该接口的实现类供我们使用
     * 意义：
     *      spring中的环绕通知：为我们提供的一种可以在代码中手动控制増强方法何时执行的方式。（其余四个通知通过配置实现）
     *
     * 当环绕通知和另外四个通知共同存在时，优先生效环绕通知（即程序出错时，异常通知并不会执行，而会执行环绕通知位于catch中的内容）
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue =null;
        try {
            Object[] args=pjp.getArgs();
            System.out.println("坏绕通知——前置：function aroundPrintLog in Logger Class is performing!");
            rtValue= pjp.proceed(args);
            System.out.println("坏绕通知——后置：function aroundPrintLog in Logger Class is performing!");

        } catch (Throwable throwable) {
            System.out.println("坏绕通知——异常：function aroundPrintLog in Logger Class is performing!");
            throwable.printStackTrace();
        }
        finally {
            System.out.println("坏绕通知——最终：function aroundPrintLog in Logger Class is performing!");
        }
        return rtValue;

    }
}