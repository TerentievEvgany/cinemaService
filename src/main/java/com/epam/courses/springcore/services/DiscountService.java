package com.epam.courses.springcore.services;


import com.epam.courses.springcore.pojo.DiscountStrategy;

import java.util.List;

public class DiscountService {
    private List<DiscountStrategy> strategies;

    public DiscountService(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }
}
