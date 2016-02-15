package com.epam.courses.springcore.services;

import com.epam.courses.springcore.dao.MapUserDAO;
import com.epam.courses.springcore.dao.UserDao;
import com.epam.courses.springcore.pojo.User;

public class UserSevice {

    private UserDao userDAO;

    public UserSevice(MapUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(User user) {
        userDAO.createUser(user);
    }

    public void deleteUser (User user) {
        userDAO.deleteUser(user);
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
 }
