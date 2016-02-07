package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapEventDAO implements EventDAO {

    private static Map<String,Event> events;

    public void createEvent(Event event) {
        events.put(event.getName(), event);
    }

    public void deleteEvent(Event event) {
        events.remove(event.getName());
    }

    public Event getByName(String name) {
        return events.get(name);
    }

    public List<Event> getAll() {
        List<Event> list = new ArrayList<Event>();
        for (String key : events.keySet()) {
            list.add(events.get(key));
        }
        return list;
    }

    public static Map<String, Event> getEvents() {
        return events;
    }

    public static void setEvents(Map<String, Event> events) {
        MapEventDAO.events = events;
    }
}
