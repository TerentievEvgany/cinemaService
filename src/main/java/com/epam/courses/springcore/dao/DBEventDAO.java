package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DBEventDAO implements EventDAO {

    private JdbcTemplate jdbcTemplate;

    public DBEventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createEvent(Event event) {
        jdbcTemplate.update("INSERT INTO events (name, rating, eventDate, auditorium) VALUES (?,?,?,?)",
                event.getName(), event.getRating().toString(), event.getEventDate(), "");
    }

    public void deleteEvent(Event event) {
        jdbcTemplate.update("DELETE FROM events where name=?",event.getName());
    }

    public Event getByName(String name) {
        Event responseUser = jdbcTemplate.queryForObject("select * from events where name = ?", new Object[]{name}, new RowMapper<Event>() {
            public Event mapRow(ResultSet resultSet, int i) throws SQLException {
                return addEvent(resultSet);
            }
        });
        return responseUser;
    }

    public List<Event> getAll() {
        List<Event> events;
         events = jdbcTemplate.query("select * from events", new RowMapper<Event>() {
            public Event mapRow(ResultSet resultSet, int i) throws SQLException {
                return addEvent(resultSet);
            }
        });
        return events;
    }

    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        return null;
    }

    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        jdbcTemplate.update("UPDATE events SET auditorium = ? WHERE name=?", new Object[] {auditorium.getName(), event.getName()});
    }

    private Event addEvent(ResultSet resultSet) throws SQLException {
        Event event = new Event(resultSet.getString("name"), Rating.valueOf(resultSet.getString("rating")), resultSet.getDate("eventDate"));
        return event;
    }
}
