package com.epam.courses.springcore.services;


import com.epam.courses.springcore.dao.MapAuditoriumDAO;
import com.epam.courses.springcore.dao.MapEventDAO;
import com.epam.courses.springcore.pojo.Auditorium;
import com.epam.courses.springcore.pojo.Event;

import java.util.Date;
import java.util.List;

public class EventService {
    private MapEventDAO mapEventDAO;
    private MapAuditoriumDAO mapAuditoriumDAO;

    public EventService(MapEventDAO mapEventDAO, MapAuditoriumDAO mapAuditoriumDAO) {
        this.mapEventDAO = mapEventDAO;
        this.mapAuditoriumDAO = mapAuditoriumDAO;
    }

    public void createEvent(Event event) {
        mapEventDAO.createEvent(event);
    }

    public void deleteEvent(Event event) {
        mapEventDAO.deleteEvent(event);
    }

    public Event getEventByName(String name) {
        return mapEventDAO.getByName(name);
    }

    public List<Event> getAllEvents() {
        return mapEventDAO.getAll();
    }

    /**
     * Assign auditorium for event for specific date. Only one auditorium for Event for specific dateTime
     */
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        //TODO: add impementation
    }

}
