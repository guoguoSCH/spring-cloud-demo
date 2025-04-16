package com.example.comorder.aspect;

import com.example.comorder.annctation.LogAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.comorder.service.*.*(..))")
    public void logPointcut(){}

    @Around("logPointcut()")
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
