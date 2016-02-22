package com.epam.courses.springcore.services;


import com.epam.courses.springcore.pojo.*;

import java.util.List;

public class DiscountService {
    private List<DiscountStrategy> strategies;

    public DiscountService(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * Returns discount for each ticket for the user on particular event
     */
    public DiscountStrategy getDiscountForUser(User user, Event event) {
        DiscountStrategy strategy;

        if (user.getBirthDate().equals(event.getEventDate())) {
            strategy = strategies.get(0);
            return strategy;
        }

        if (user.getBookedTickets()!=null && user.getBookedTickets().size()%10 == 9) {
            strategy = strategies.get(1);
            return strategy;
        }
        return null;
    }

    public List<DiscountStrategy> getStrategies() {
        return strategies;
    }
}
