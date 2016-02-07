package com.epam.courses.springcore.pojo;


import java.util.Date;
import java.util.List;

public class Event {

    private String name;
    private String rating;
    private double ticketPrice;
    private List<Date> eventDates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<Date> getEventDates() {
        return eventDates;
    }

    public void setEventDates(List<Date> eventDates) {
        this.eventDates = eventDates;
    }
}
