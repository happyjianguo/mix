/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.springannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Log.java, v 0.1 2018年04月26日 下午7:00 chuanshi.hzh Exp $
 */
@Aspect
public class Log {

    @Pointcut("execution(* test.springannotation.Chief.*(..))")
    public void chiefPointCut() {
    }

    public void washOven() {
        System.out.println("washOven,logging.....");
    }

    @Before("chiefPointCut()")
    public void checkOrder(JoinPoint joinpoint) {
        System.out.println(joinpoint.getSignature());
        for (Object item : joinpoint.getArgs()) {
            if (item instanceof Cake) {
                Cake cake = (Cake) item;
                System.out.println(cake.getName());
            }
        }
    }

    public void prepare() {
        System.out.println("prepare,logging.....");
    }

    public void after() {
        System.out.println("after someting to do,logging.....");
    }

    @Around("chiefPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        washOven();
        prepare();
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("use time:" + (endTime - startTime));
        after();
    }

}