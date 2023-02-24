package com.naconfig.aspect;

import com.naconfig.value.AllValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private AllValue allValue;

    @Pointcut(value = "@annotation(com.naconfig.aspect.anno.Log)")
    public void logCut() {}

//    @Before(value = "logCut()")
//    public void before() {
//        System.out.println("before");
//        logger.info("before");
//    }

    @Around(value = "logCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        logger.info(allValue.getChangedValue());
        return point.proceed();
    }

//    @After(value = "logCut()")
//    public void after() {
//        System.out.println("after");
//        logger.info("after");
//    }
}
