package com.costa.luiz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
//@Component
public class AroundMethod {

    private final Logger logger = LoggerFactory.getLogger(AroundMethod.class);

    @Around("execution(* com.costa.luiz.aspect.CustomerRepository.*(..))")
    public void anyMethod(ProceedingJoinPoint proceedingJoinPoint) {
        // Any validation
        boolean isValid = true;
        if (isValid) {
            try {
                proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                logger.error("{}", throwable.getMessage(), throwable);
            }
        }
    }

    @Around("execution(* com.costa.luiz.aspect.CustomerRepository.findAll(..))")
    public void findAll(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("{}", "Lets find all");
        //proceedingJoinPoint.proceed();
    }
}
