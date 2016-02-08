package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Auditorium;
import com.epam.courses.springcore.pojo.Event;
import com.epam.courses.springcore.pojo.Ticket;

import java.util.*;

public class MapEventDAO implements EventDAO {

    private static Map<String,Event> events;

    static {
        events = new HashMap<String, Event>();
    }

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

    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        if (events.get(event.getName()) != null && events.get(event.getName()).getEventDate().equals(date)) {
            if (events.get(event.getName()).getTickets() != null) {
                return events.get(event.getName()).getTickets();
            }
        }
        return null;
    }

    public List<Event> getForDateRange(Date from, Date to) {
        List<Event> eventsList = new ArrayList<Event>();
        for(Event event : events.values()){
            if(event.getEventDate().after(from) && event.getEventDate().before(to)){
                eventsList.add(event);
            }
        }
        return eventsList;
    }

    public List<Event> getNextEvents(Date to) {
        List<Event> eventsList = new ArrayList<Event>();
        for(Event event : events.values()){
            if(event.getEventDate().before(to)){
                eventsList.add(event);
            }
        }
        return eventsList;
    }

    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        event.setAuditorium(auditorium);
        event.setEventDate(date);
        events.put(event.getName(), event);
    }

    public static Map<String, Event> getEvents() {
        return events;
    }

    public static void setEvents(Map<String, Event> events) {
        MapEventDAO.events = events;
    }
}
