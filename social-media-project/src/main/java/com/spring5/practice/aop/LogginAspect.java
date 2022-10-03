package com.spring5.practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogginAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.spring5.practice.controllers.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.spring5.practice.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("======>> in @Before calling method : "+theMethod);


        Object [] args = joinPoint.getArgs();
        for(Object temp: args){
            myLogger.info("======>> arguments : "+temp);
        }
    }
}
