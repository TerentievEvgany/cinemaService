package com.epam.courses.springcore.pojo;

public class TenTicketStrategy implements DiscountStrategy {
    private int discount;

    public TenTicketStrategy(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }
}
