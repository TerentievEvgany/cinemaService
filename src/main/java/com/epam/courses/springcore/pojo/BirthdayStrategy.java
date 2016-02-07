package com.epam.courses.springcore.pojo;

public class BirthdayStrategy implements DiscountStrategy {
    private int discount;

    public BirthdayStrategy(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }
}
