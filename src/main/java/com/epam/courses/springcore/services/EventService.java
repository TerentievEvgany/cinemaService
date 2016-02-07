package com.epam.courses.springcore.services;


import com.epam.courses.springcore.dao.MapEventDAO;
import com.epam.courses.springcore.pojo.Event;

import java.util.List;

public class EventService {
    private MapEventDAO mapEventDAO;

    public EventService(MapEventDAO mapEventDAO) {
        this.mapEventDAO = mapEventDAO;
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
}
