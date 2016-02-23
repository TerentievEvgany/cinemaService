package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Ticket;
import com.epam.courses.springcore.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUserDAO implements UserDao{
    JdbcTemplate jdbcTemplate;

    public DBUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(User user) {
        jdbcTemplate.update("INSERT INTO users (id, name, email) VALUES (?,?,?)",
                user.getId(), user.getUserName(), user.getEmail());
    }

    public void deleteUser(User user) {
        jdbcTemplate.update("DELETE FROM users where id=?",user.getId());
    }

    public User getUserByName(String name) {
        User responseUser = jdbcTemplate.queryForObject("select * from users where name = ?", new Object[]{name}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return createUser(resultSet);
            }
        });
        return responseUser;
    }

    public User getUserById(long id) {
        User responseUser = jdbcTemplate.queryForObject("select * from users where id = ?", new Object[]{id}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return createUser(resultSet);
            }
        });
        return responseUser;
    }

    public User getUserByEmail(String email) {
        User responseUser = jdbcTemplate.queryForObject("select * from users where email = ?", new Object[]{email}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return createUser(resultSet);
            }
        });
        return responseUser;
    }

    public void addBookedTicket(Ticket ticket, User user) {

    }

    private User createUser(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        User user = new User(id, name, email);
        return user;
    }
}
