package com.example.commember.aspect;

import com.example.commember.anotation.LogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.commember.controller.*.*(..))")
    public void logPointcut(){}

    @AfterReturning("logPointcut()")
    public void afterLog(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation customAnnotation = method.getAnnotation(LogAnnotation.class);
        System.out.println(customAnnotation.name() + "-" + customAnnotation.age() + "-" + customAnnotation.sex());
    }

    @Before("logPointcut()")
    public void beforeLog(){
        System.out.println("我在开始执行");
    }
}
