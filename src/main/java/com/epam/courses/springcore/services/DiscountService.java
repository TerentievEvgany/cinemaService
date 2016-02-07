package com.epam.courses.springcore.services;


import com.epam.courses.springcore.pojo.DiscountStrategy;
import com.epam.courses.springcore.pojo.Event;
import com.epam.courses.springcore.pojo.User;

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
    public BigDecimal getDiscount(User user, Event event, Date date) {
        //TODO: add implementations
        return null;
    }
}
