package com.costa.luiz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Aspect
@Component
public class BeforeMethod {

    private final Logger logger = LoggerFactory.getLogger(BeforeMethod.class);

    @Before("execution(* com.costa.luiz.aspect.CustomerRepository.*(..))")
    public void anyMethod(JoinPoint joinPoint) {
        final Object argument = joinPoint.getArgs().length > 0 ? joinPoint.getArgs()[0] : "";
        logger.info("{} {}", "Calling the method using the argument", argument);
        final String kind = joinPoint.getKind();
        logger.info("{}", kind);
        final Signature signature = joinPoint.getSignature();
        logger.info("{} -> {}", "signature of call", signature);
    }

    @Before("execution(* com.costa.luiz.aspect.CustomerRepository.delete(..))")
    public void beforeDelete(JoinPoint joinPoint) {
        logger.info(joinPoint.toString());
    }
}
