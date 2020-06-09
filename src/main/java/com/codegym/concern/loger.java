package com.codegym.concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class loger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.CustomerService.save(..))")
    public void log() {
        System.out.println("save bi loi");
    }
}
