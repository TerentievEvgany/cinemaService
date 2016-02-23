package com.epam.courses.aop.aspects;

import com.epam.courses.springcore.pojo.Counter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Aspect
public class CounterAspect {
    private JdbcTemplate jdbcTemplate;

    public CounterAspect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        Counter count = getCounter(joinPoint);
        jdbcTemplate.update("UPDATE counters SET count = ? WHERE name=?", new Object[] {count.getCount()+1, count.getName()});

    }

    public static Map<String, Integer> getCounter() {
        return counter;
    }

    private Counter getCounter(JoinPoint joinPoint) {
        Counter counter = jdbcTemplate.queryForObject("select * from counters where name = ?", new Object[]{joinPoint.getSignature().getName()}, new RowMapper<Counter>() {
            public Counter mapRow(ResultSet resultSet, int i) throws SQLException {
                Counter counter = new Counter(resultSet.getString("name"), resultSet.getInt("count"));
                return counter;
            }
        });
        return counter;
    }
}
