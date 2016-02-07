package com.epam.courses.springcore.pojo;

public class Auditorium {

    private String name;
    private String vipSeats;
    private int seatsNumber;

    public Auditorium(String name, String vipSeats, int seatsNumber) {
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

    public String getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(String vipSeats) {
        this.vipSeats = vipSeats;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }
}
