package com.foxbill.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class MyAdvice {
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
