package com.epam.courses.springcore.services;

import com.epam.courses.springcore.dao.MapAuditoriumDAO;
import com.epam.courses.springcore.dao.MapEventDAO;
import com.epam.courses.springcore.dao.MapUserDAO;
import com.epam.courses.springcore.pojo.Event;
import com.epam.courses.springcore.pojo.Ticket;
import com.epam.courses.springcore.pojo.User;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class BookingService {
    private MapAuditoriumDAO auditoriumDAO;
    private MapEventDAO mapEventDAO;
    private MapUserDAO userDAO;

    public BookingService(MapAuditoriumDAO auditoriumDAO, MapEventDAO mapEventDAO, MapUserDAO userDAO) {
        this.auditoriumDAO = auditoriumDAO;
        this.mapEventDAO = mapEventDAO;
        this.userDAO = userDAO;
    }

    /**
     * Get all purchased tickets for event for specific date.
     */
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        //TODO: add implementation
        return null;
    }

    /**
     * User could  be registered or not. If user is registered, then booking information is stored for that user.
     * Purchased tickets for particular event should be stored.
     */
    public void bookTicket(User user, Ticket ticket){
        //TODO: add implementation
    }

    /**
     * Returns price for ticket for specified event on specific date and time for specified seats
     */
    public BigDecimal getTicketPrice(Event event, Date date, Time time, String seats, User user) {
        //TODO: add implementation
        return null;
    }
}
