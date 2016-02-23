package com.epam.courses.springcore.dao;


import com.epam.courses.springcore.pojo.Auditorium;

import java.util.List;

public interface AuditoriumDAO {
    public List<Auditorium> getAllAuditoriums();
    public Auditorium getAuditoriumByName(String name);
    public void addAuditorium(Auditorium auditorium);
}
