package com.epam.courses.springcore.dao;


import com.epam.courses.springcore.pojo.Ticket;
import com.epam.courses.springcore.pojo.User;

public interface UserDao {
    public void createUser(User user);
    public void deleteUser(User user);
    public User getUserByName(String name);
    public User getUserById(long id);
    public User getUserByEmail(String email);
    public void addBookedTicket(Ticket ticket, User user);
}
