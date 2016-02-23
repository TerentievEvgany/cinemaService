package com.epam.courses.springcore.pojo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Event {

    private String name;
    private Rating rating;
    private BigDecimal ticketPrice;
    private Date eventDate;
    private Auditorium auditorium;
    private List<Ticket> tickets;


    public Event(String name, Rating rating, BigDecimal ticketPrice, Date eventDate) {
        this.name = name;
        this.rating = rating;
        this.ticketPrice = ticketPrice;
        this.eventDate = eventDate;
    }

    public Event(String name, Rating rating, Date eventDate) {
        this.name = name;
        this.rating = rating;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
