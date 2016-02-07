package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.User;

import java.util.Map;

public class MapUserDAO implements UserDao{

    private static Map<Long,User> users;


    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(User user) {
        users.remove(user.getId());
    }

    public User getUserByName(String name) {
        for (Long key: users.keySet()){
            if (users.get(key).getEmail() == name) {
                return users.get(key);
            }
        }
        return null;
    }

    public User getUserById(long id) {
        return users.get(id);
    }

    public User getUserByEmail(String email) {
        for (Long key: users.keySet()){
            if (users.get(key).getEmail() == email) {
                return users.get(key);
            }
        }
        return null;
    }

    public static Map<Long, User> getUsers() {
        return users;
    }

    public static void setUsers(Map<Long, User> users) {
        MapUserDAO.users = users;
    }
}
