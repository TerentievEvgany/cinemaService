package com.epam.courses.springcore;

import com.epam.courses.springcore.pojo.*;
import com.epam.courses.springcore.services.AuditoriumService;
import com.epam.courses.springcore.services.BookingService;
import com.epam.courses.springcore.services.EventService;
import com.epam.courses.springcore.services.UserSevice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit test for simple Cinema Service.
 */
public class CinemaTest {

    @Test
    public void userRegistrationTest() {
        User user = new User(1, "Test", "test@mail.com");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserSevice userSevice = (UserSevice) ctx.getBean("userService");
        userSevice.registerUser(user);
        assertEquals(userSevice.getUserById(user.getId()), user);
    }

    @Test
    public void userDeleteTest() {
        User user = new User(1, "Test", "test@mail.com");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserSevice userSevice = (UserSevice) ctx.getBean("userService");
        userSevice.registerUser(user);
        userSevice.deleteUser(user);
        assertEquals(userSevice.getUserById(user.getId()), null);
    }

    @Test
    public void getUserByEmailAndNameTest() {
        User user = new User(1, "Test", "test@mail.com");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserSevice userSevice = (UserSevice) ctx.getBean("userService");
        userSevice.registerUser(user);
        assertEquals(userSevice.getUserByEmail(user.getEmail()), user);
        assertEquals(userSevice.getUserByName(user.getUserName()), user);
    }

    @Test
    public void createEventTest(){
        Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EventService eventService = (EventService) ctx.getBean("eventService");
        eventService.createEvent(event);
        assertEquals(eventService.getEventByName(event.getName()), event);
    }

    @Test
    public void getAllEventsTest() {
        Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EventService eventService = (EventService) ctx.getBean("eventService");
        eventService.createEvent(event);
        assertEquals(eventService.getAllEvents(), Arrays.asList(event));
    }

    @Test
    public void deleteEventTest() {
        Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EventService eventService = (EventService) ctx.getBean("eventService");
        eventService.createEvent(event);
        eventService.deleteEvent(event);
        assertTrue(eventService.getAllEvents().isEmpty());
    }

    @Test
    public void assighnAuditoriumTest() {
        Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EventService eventService = (EventService) ctx.getBean("eventService");
        Auditorium auditorium = ctx.getBean(Auditorium.class);
        eventService.createEvent(event);
        eventService.assignAuditorium(event, auditorium, new Date());
        assertEquals(event.getAuditorium(), auditorium);
    }

    @Test
    public void getAuditoriumsTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        AuditoriumService auditoriumService = ctx.getBean(AuditoriumService.class);
        assertTrue(auditoriumService.getAuditoriums().size() == 1);
    }

    @Test
    public void getTicketsForEventTest() {
        Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EventService eventService = (EventService) ctx.getBean("eventService");
        BookingService bookingService = ctx.getBean(BookingService.class);
        Auditorium auditorium = ctx.getBean(Auditorium.class);
        eventService.createEvent(event);
        eventService.assignAuditorium(event, auditorium, new Date());
        Ticket ticket_1 = new Ticket(new BigDecimal(75), 10);
        Ticket ticket_2 = new Ticket(new BigDecimal(75), 11);
        Ticket ticket_3= new Ticket(new BigDecimal(75), 12);
        event.setTickets(Arrays.asList(ticket_1, ticket_2,ticket_3));
        assertEquals(bookingService.getTicketsForEvent(event,event.getEventDate()), Arrays.asList(ticket_1, ticket_2,ticket_3));
    }

}
