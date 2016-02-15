package com.epam.courses.springcore.services;


import com.epam.courses.springcore.dao.AuditoriumDAO;
import com.epam.courses.springcore.dao.EventDAO;
import com.epam.courses.springcore.pojo.Auditorium;
import com.epam.courses.springcore.pojo.Event;

import java.util.Date;
import java.util.List;

public class EventService {
    private EventDAO eventDAO;
    private AuditoriumDAO auditoriumDAO;

    public EventService(EventDAO eventDAO, AuditoriumDAO auditoriumDAO) {
        this.eventDAO = eventDAO;
        this.auditoriumDAO = auditoriumDAO;
    }

    public void createEvent(Event event) {
        eventDAO.createEvent(event);
    }

    public void deleteEvent(Event event) {
        eventDAO.deleteEvent(event);
    }

    public Event getEventByName(String name) {
        return eventDAO.getByName(name);
    }

    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    /**
     * Assign auditorium for event for specific date. Only one auditorium for Event for specific dateTime
     */
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        eventDAO.assignAuditorium(event, auditorium, date);
    }

}
