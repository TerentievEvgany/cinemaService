package com.epam.courses.springcore.pojo;

import java.util.List;

public class Auditorium {

    private String name;
    private List<String> vipSeats;
    private int seatsNumber;

    public Auditorium(String name, List<String> vipSeats, int seatsNumber) {
        this.name = name;
        this.vipSeats = vipSeats;
        this.seatsNumber = seatsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVipSeats(List<String> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public List<String> getVipSeats() {
        return vipSeats;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }
}
