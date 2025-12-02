package tn.esprit.gestionfoyer.AOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class Performance {

    @Around("execution(* tn.esprit.gestionfoyer.services.*.*(..))")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis()-startTime;
        log.info("Method execution time: {} ms", endTime);
        return result;
    }
}
