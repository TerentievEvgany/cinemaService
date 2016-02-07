package com.epam.courses.springcore.services;

import com.epam.courses.springcore.dao.MapAuditoriumDAO;
import com.epam.courses.springcore.dao.MapEventDAO;
import com.epam.courses.springcore.dao.MapUserDAO;
import com.epam.courses.springcore.pojo.Event;
import com.epam.courses.springcore.pojo.Ticket;
import com.epam.courses.springcore.pojo.User;

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

    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        //TODO: add implementation
        return null;
    }

    public void bookTicket(User user, Ticket ticket){
        //TODO: add implementation
    }
}
