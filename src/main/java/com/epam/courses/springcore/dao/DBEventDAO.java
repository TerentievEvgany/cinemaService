package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Auditorium;
import com.epam.courses.springcore.pojo.Event;
import com.epam.courses.springcore.pojo.Ticket;

import java.util.Date;
import java.util.List;

public class DBEventDAO implements EventDAO {
    public void createEvent(Event event) {

    }

    public void deleteEvent(Event event) {

    }

    public Event getByName(String name) {
        return null;
    }

    public List<Event> getAll() {
        return null;
    }

    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        return null;
    }

    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {

    }
}
