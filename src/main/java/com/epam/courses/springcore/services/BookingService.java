package com.epam.courses.springcore.services;

import com.epam.courses.springcore.dao.MapAuditoriumDAO;
import com.epam.courses.springcore.dao.MapEventDAO;
import com.epam.courses.springcore.dao.MapUserDAO;

public class BookingService {
    private MapAuditoriumDAO auditoriumDAO;
    private MapEventDAO mapEventDAO;
    private MapUserDAO userDAO;

    public BookingService(MapAuditoriumDAO auditoriumDAO, MapEventDAO mapEventDAO, MapUserDAO userDAO) {
        this.auditoriumDAO = auditoriumDAO;
        this.mapEventDAO = mapEventDAO;
        this.userDAO = userDAO;
    }
}
