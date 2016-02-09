package com.epam.courses.springcore.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {

    private BigDecimal price;
    private int seatNumber;

    public Ticket(BigDecimal price, int seatNumber) {
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
