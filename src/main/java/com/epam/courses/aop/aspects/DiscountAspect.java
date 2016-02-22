package com.epam.courses.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class DiscountAspect {
    private static Map<Class<?>, Integer> discountTotalCounter;

    static {
        discountTotalCounter = new HashMap<Class<?>, Integer>();
    }

    @Pointcut("execution(* *.getDiscount(..))")
    private void getDiscount() {}

    @Pointcut("execution(* *.getDiscountForUser(..))")
    private void getDiscountForUser() {}

    @AfterReturning("getDiscount()")
    public void countTotalDiscounts(JoinPoint joinPoint) {

        if (!discountTotalCounter.containsKey(joinPoint.getTarget().getClass())) {
            discountTotalCounter.put(joinPoint.getTarget().getClass(), 0);
        }
        discountTotalCounter.put(joinPoint.getTarget().getClass(), discountTotalCounter.get(joinPoint.getTarget().getClass()) + 1);
    }

   /* @AfterReturning("getDiscountForUser()")
    public void getDiscountsForUser(JoinPoint joinPoint) {
       //joinPoint.getSignature();
    }*/
}
