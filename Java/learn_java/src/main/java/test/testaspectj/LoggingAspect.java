package test.testaspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by joshua on 17/3/23.
 */
@Aspect
public class LoggingAspect {

    @Before("execution(* test.testaspectj.CustomerBo.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logBefore() is running");
        System.out.println("join: " + joinPoint.getSignature().getName());
        System.out.println("=========");
    }
}
