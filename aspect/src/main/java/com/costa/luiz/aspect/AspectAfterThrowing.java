package com.costa.luiz.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AspectAfterThrowing {

    private final Logger LOGGER = LoggerFactory.getLogger(AspectAfterThrowing.class);

    @AfterThrowing(pointcut = "execution(* com.costa.luiz.aspect.Customer.*(..))", throwing = "exception")
    public void logAfterThrowingAllMethods(RuntimeException exception) {
        LOGGER.info("One way to catch the Exception");
        LOGGER.info(exception.getMessage()+ " at "+ LocalDateTime.now());
    }

    @AfterThrowing ("execution(* com.costa.luiz.aspect.Customer.*(..)   )")
    public void logAfterThrowingAllMethods() {
        //  Havy @AfterThrowing(pointcut = "execution(public * *(..))", throwing = "ex")
        LOGGER.info("--------- at "+ LocalDateTime.now());
    }
}
