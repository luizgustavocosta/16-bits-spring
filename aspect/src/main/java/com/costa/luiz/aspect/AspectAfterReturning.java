package com.costa.luiz.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfterReturning {

    private final Logger logger = LoggerFactory.getLogger(AspectAfterReturning.class);

    @AfterReturning(pointcut = "execution(* com.costa.luiz.aspect.CustomerRepository.findAll(..))", returning = "object")
    public void findAll(Object object) {
        logger.info("{} -> {}","Content", object);
    }
}
