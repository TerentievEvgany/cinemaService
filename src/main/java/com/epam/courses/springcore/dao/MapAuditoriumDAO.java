package com.epam.courses.springcore.dao;

import com.epam.courses.springcore.pojo.Auditorium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAuditoriumDAO implements AuditoriumDAO {

    private static Map<String, Auditorium> auditoriums;
    private List<Auditorium> list;

    static {
        auditoriums = new HashMap<String, Auditorium>();
    }

    public MapAuditoriumDAO(List<Auditorium> list) {
        this.list = list;
        for (Auditorium auditorium: this.list) {
            auditoriums.put(auditorium.getName(),auditorium);
        }
    }

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

}
