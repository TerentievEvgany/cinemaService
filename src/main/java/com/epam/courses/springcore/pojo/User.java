package com.epam.courses.springcore.pojo;


import java.util.Date;
import java.util.List;

public class User {

    private long id;
    private String userName;
    private String email;
    private List<Ticket> bookedTickets;
    private Date birthDate;

    public User(long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public User(long id, String userName, String email, Date birthDate) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
