package com.iheb.evenementdevoir.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogginAspect {

    @AfterThrowing("execution(* com.iheb.evenementdevoir.service.TicketService.ajouterTicketsEtAffecterAEvenementEtInternaute(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name =joinPoint.getSignature().getName();
        log.info("In methoaaaaaaaaaaaaaaaaad "+name+" : ");
    }

}
