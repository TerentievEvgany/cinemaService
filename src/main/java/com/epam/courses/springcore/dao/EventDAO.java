package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Event;

import java.util.List;

public interface EventDAO {
    public void createEvent(Event event);
    public void deleteEvent(Event event);
    public Event getByName(String name);
    public List<Event> getAll();
}
