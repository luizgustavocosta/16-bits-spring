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

    private final Logger logger = LoggerFactory.getLogger(AspectAfterThrowing.class);

    @AfterThrowing(pointcut = "execution(* com.costa.luiz.aspect.CustomerService.*(..))", throwing = "exception")
    public void logAfterThrowingAllMethods(RuntimeException exception) {
        logger.info("One way to catch the Exception");
        logger.info("{} at {}", exception.getMessage(), LocalDateTime.now());
    }

    @AfterThrowing ("execution(* com.costa.luiz.aspect.CustomerService.*(..)   )")
    public void logAfterThrowingAllMethods() {
        //  Heavy @AfterThrowing(pointcut = "execution(public * *(..))", throwing = "ex")
        logger.info("{} {}","--------- at ",LocalDateTime.now());
    }
}
