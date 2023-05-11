package com.example.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAop {


    Logger log = LoggerFactory.getLogger(LogAop.class);
    //@Pointcut("execution(* com.example.demo.modules..controller.*.*(..))")
    @Pointcut("within(com.example.demo.modules..service.*)")
    //@Pointcut("this(com.example.demo.modules.service.DepartmentService)")
    public void loggingPointCut(){}

    @Before("loggingPointCut()")
    public void before( JoinPoint joinPoint ){
        log.info("Before method invoked::"+joinPoint.getSignature());
    }
}
