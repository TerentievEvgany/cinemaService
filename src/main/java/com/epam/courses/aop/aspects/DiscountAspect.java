package com.epam.courses.aop.aspects;

import com.epam.courses.springcore.pojo.DiscountStrategy;
import com.epam.courses.springcore.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Aspect
public class DiscountAspect {
    private static Map<Class<?>, Integer> discountTotalCounter;
    private static Map<Long, Map<Class<?>, Integer>> discountForUserCounter;

    static {
        discountTotalCounter = new HashMap<Class<?>, Integer>();
        discountForUserCounter = new HashMap<Long, Map<Class<?>, Integer>>();
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

    @AfterReturning(pointcut = "getDiscountForUser()", returning = "discount")
    public void getDiscountsForUser(JoinPoint joinPoint, DiscountStrategy discount) {
        User user = (User)joinPoint.getArgs()[0];

        if (!discountForUserCounter.containsKey(user.getId())){
            discountForUserCounter.put(user.getId(), countDiscounts(discount, new HashMap<Class<?>, Integer>()));
        }
        discountForUserCounter.put(user.getId(), countDiscounts(discount,discountForUserCounter.get(user.getId())));
    }

    private Map<Class<?>, Integer> countDiscounts(DiscountStrategy strategy,  Map<Class<?>, Integer> map) {
        if (!map.containsKey(strategy.getClass())) {
            map.put(strategy.getClass(), 0);
        }
        map.put(strategy.getClass(), map.get(strategy.getClass()) + 1);
        return map;
    }

    public static Map<Class<?>, Integer> getDiscountTotalCounter() {
        return discountTotalCounter;
    }

    public static Map<Long, Map<Class<?>, Integer>> getDiscountForUserCounter() {
        return discountForUserCounter;
    }
}
