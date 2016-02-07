package com.epam.courses.springcore.services;

import com.epam.courses.springcore.dao.MapAuditoriumDAO;
import com.epam.courses.springcore.pojo.Auditorium;

import java.util.List;

public class AuditoriumService {
    private MapAuditoriumDAO auditoriumDAO;

    public AuditoriumService(MapAuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public MapAuditoriumDAO getAuditoriumDAO() {
        return auditoriumDAO;
    }

    public void setAuditoriumDAO(MapAuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public List<Auditorium> getAuditoriums(){
        return auditoriumDAO.getAllAuditoriums();
    }

    public int getSeatsNumber(String name) {
        return auditoriumDAO.getAuditoriumByName(name).getSeatsNumber();
    }

    public String getVipSeats(String name) {
        return auditoriumDAO.getAuditoriumByName(name).getVipSeats();
    }
}
