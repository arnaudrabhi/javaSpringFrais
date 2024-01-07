package fr.limayrac.declarationFrais.declarationFrais.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* fr.limayrac.declarationFrais.declarationFrais.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method execution started: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* fr.limayrac.declarationFrais.declarationFrais.Service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method executed successfully: {}", joinPoint.getSignature());
        logger.info("Returned value: {}", result);
    }

    @AfterThrowing(pointcut = "execution(* fr.limayrac.declarationFrais.declarationFrais.Service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: {}", joinPoint.getSignature());
        logger.error("Exception message: {}", exception.getMessage());
    }
}
