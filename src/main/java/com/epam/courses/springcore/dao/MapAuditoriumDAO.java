package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Auditorium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapAuditoriumDAO implements AuditoriumDAO {

    private static Map<String, Auditorium> auditoriums;

    public static Map<String, Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public static void setAuditoriums(Map<String, Auditorium> auditoriums) {
        MapAuditoriumDAO.auditoriums = auditoriums;
    }

    public List<Auditorium> getAllAuditoriums() {
        List<Auditorium> auditoriumList = new ArrayList<Auditorium>();
        for (String key : auditoriums.keySet()) {
            auditoriumList.add(auditoriums.get(key));
        }
        return auditoriumList;
    }

    public Auditorium getAuditoriumByName(String name) {
        return auditoriums.get(name);
    }

    public Auditorium getAuditoriumByNameFromList(String name) {
        for (Auditorium auditorium : getAllAuditoriums()) {
            if (auditorium.getName() == name) {
                return auditorium;
            }
        }
        return null;
    }
}
