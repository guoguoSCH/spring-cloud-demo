package com.example.commember.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.commember.controller.*.*(..))")
    public void logPointcut(){}

    @AfterReturning("logPointcut()")
    public void afterLog(){
        System.out.println("我在结束执行");
    }

    @Before("logPointcut()")
    public void beforeLog(){
        System.out.println("我在开始执行");
    }
}
