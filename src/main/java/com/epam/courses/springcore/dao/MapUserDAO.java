package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Ticket;
import com.epam.courses.springcore.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapUserDAO implements UserDao{

    private static Map<Long,User> users;

    static {
        users = new HashMap<Long, User>();
    }


    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(User user) {
        users.remove(user.getId());
    }

    public User getUserByName(String name) {
        for (Long key: users.keySet()){
            if (users.get(key).getUserName() == name) {
                return users.get(key);
            }
        }
        return null;
    }

    public User getUserById(long id) {
        if (users.get(id) != null) {
            return users.get(id);
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (Long key: users.keySet()){
            if (users.get(key).getEmail() == email) {
                return users.get(key);
            }
        }
        return null;
    }

    public void addBookedTicket(Ticket ticket, User user) {
        if (user.getBookedTickets() != null) {
            user.getBookedTickets().add(ticket);
        } else {
            user.setBookedTickets(new ArrayList<Ticket>());
            user.getBookedTickets().add(ticket);
        }

    }

    public static Map<Long, User> getUsers() {
        return users;
    }

    public static void setUsers(Map<Long, User> users) {
        MapUserDAO.users = users;
    }
}
