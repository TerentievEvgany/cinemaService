package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Auditorium;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBAuditoriumDAO implements AuditoriumDAO {
    JdbcTemplate jdbcTemplate;

    public DBAuditoriumDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Auditorium> getAllAuditoriums() {
        List<Auditorium> auditoriums;
        auditoriums = jdbcTemplate.query("select * from auditoriums", new RowMapper<Auditorium>() {
            public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
                Auditorium auditorium = new Auditorium(resultSet.getString("name"), Arrays.asList(resultSet.getString("vipSeats").split("\\s*,\\s*")),resultSet.getInt("seatNumber"));
                return auditorium;
            }
        });
        return auditoriums;
    }

    public Auditorium getAuditoriumByName(String name) {
        Auditorium auditoriumByName = jdbcTemplate.queryForObject("select * from auditoriums where name = ?", new Object[]{name}, new RowMapper<Auditorium>() {
            public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
                Auditorium auditorium = new Auditorium(resultSet.getString("name"), Arrays.asList(resultSet.getString("vipSeats").split("\\s*,\\s*")),resultSet.getInt("seatNumber"));
                return auditorium;
            }
        });
      return auditoriumByName;
    }

    public void addAuditorium(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO auditoriums (name, vipSeats, seatNumber) VALUES (?,?,?)",
                auditorium.getName(), auditorium.getVipSeats().toString(), auditorium.getSeatsNumber());
    }

}
