/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nilton Fernando
 */
@Component
@Aspect
public class AspectClass {

    @Around("execution(* printt(..))")
    public Object teste(ProceedingJoinPoint pjp) throws Throwable{
        Object o = pjp.proceed();
        System.out.println("core.com.spring.test.AspectClass.teste() " + o);
        return o;
    }
}
