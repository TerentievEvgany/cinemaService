package com.epam.courses.springcore.services;


import com.epam.courses.springcore.pojo.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DiscountService {
    private List<DiscountStrategy> strategies;

    public DiscountService(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * Returns discount for each ticket for the user on particular event
     */
    public BigDecimal getDiscountForUser(User user, Event event) {
        BigDecimal discount = new BigDecimal(0);
        BirthdayStrategy strategy;

        if (user.getBirthDate().equals(event.getEventDate())) {
            strategy = (BirthdayStrategy) strategies.get(0);
            discount = discount.add(new BigDecimal(strategy.getDiscount()));
        }

        if (user.getBookedTickets().size()%10 == 9) {
            strategy = (BirthdayStrategy) strategies.get(0);
            discount = discount.add(new BigDecimal(strategy.getDiscount()));
        }
        return discount;
    }

    public List<DiscountStrategy> getStrategies() {
        return strategies;
    }
}
