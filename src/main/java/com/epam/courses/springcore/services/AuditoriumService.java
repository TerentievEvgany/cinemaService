package com.epam.courses.springcore.services;

import com.epam.courses.springcore.dao.AuditoriumDAO;
import com.epam.courses.springcore.dao.MapAuditoriumDAO;
import com.epam.courses.springcore.pojo.Auditorium;

import java.util.List;

public class AuditoriumService {
    private AuditoriumDAO auditoriumDAO;

    public AuditoriumService(MapAuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public List<Auditorium> getAuditoriums(){
        return auditoriumDAO.getAllAuditoriums();
    }

    public int getSeatsNumber(String name) {
        return auditoriumDAO.getAuditoriumByName(name).getSeatsNumber();
    }

    public List<String> getVipSeats(String name) {
        return auditoriumDAO.getAuditoriumByName(name).getVipSeats();
    }
}
