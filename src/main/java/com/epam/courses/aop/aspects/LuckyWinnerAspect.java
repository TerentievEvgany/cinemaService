package com.epam.courses.aop.aspects;

import com.epam.courses.springcore.pojo.Ticket;
import com.epam.courses.springcore.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.math.BigDecimal;
import java.util.Random;

@Aspect
public class LuckyWinnerAspect {
    @Pointcut("execution(* *.bookTicket(..))")
    private void bookTicket() {}

    @Around("bookTicket() && args(user, ticket)")
    public void setLuckyUser(ProceedingJoinPoint proceedingJoinPoint, User user, Ticket ticket) throws Throwable {
        if (luckyUser()) {
            ticket.setPrice(new BigDecimal(0));
            proceedingJoinPoint.proceed(new Object[] { user, ticket});
        }
    }

    private boolean luckyUser(){
        Random random = new Random();
        if (random.nextInt()%2 == 0) return true;
        return false;
    }
}
