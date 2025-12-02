package tn.esprit.gestionfoyer.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution (* tn.esprit.gestionfoyer.services.FoyerService.*(..))")
   public void logMethod(final JoinPoint joinPoint) {
       String name = joinPoint.getSignature().getName();
       log.info("In methode " + name +": ");
   }




}
