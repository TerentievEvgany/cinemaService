package com.epam.courses.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CounterAspect {

    private static Map<String,Integer> counter;

    static {
        counter = new HashMap<String, Integer>();
    }

    @Pointcut("execution(* *.getEventByName(..))")
    private void getEventByNameCounter(){}

    @Pointcut("execution(* *.bookTicket(..))")
    private void getTicketPricesCounter() {}

    @Pointcut ("execution(* *.getTicketPrice(..))")
    private void getBookingTicketsCounter() {}

    @Pointcut("getEventByNameCounter() || getBookingTicketsCounter() || getTicketPricesCounter()")
    private void allMethodsCounter() {}


    @AfterReturning("allMethodsCounter()")
    public void count(JoinPoint joinPoint) {
        if (!counter.containsKey(joinPoint.getSignature().getName())) {
            counter.put(joinPoint.getSignature().getName(), 0);
        }
        counter.put(joinPoint.getSignature().getName(), counter.get(joinPoint.getSignature().getName()) + 1);
    }

    public static Map<String, Integer> getCounter() {
        return counter;
    }
}
