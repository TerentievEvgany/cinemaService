package com.epam.courses.springcore;

import com.epam.courses.aop.aspects.CounterAspect;
import com.epam.courses.aop.aspects.DiscountAspect;
import com.epam.courses.springcore.pojo.*;
import com.epam.courses.springcore.services.*;
import org.h2.tools.Server;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit test for simple Cinema Service.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class CinemaTest {

    @Autowired
    private UserSevice userSevice;

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private DiscountService discountService;

    private User user = new User(1, "Test", "test@mail.com", new Date());
    private Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
    private Ticket ticket_1 = new Ticket(new BigDecimal(75), 10);
    private Ticket ticket_2 = new Ticket(new BigDecimal(75), 11);
    private Ticket ticket_3= new Ticket(new BigDecimal(75), 12);
    private Auditorium auditorium = new Auditorium("Test",Arrays.asList("1", "2", "3"),1);

    @Test
    public void userRegistrationTest() {
        userSevice.registerUser(user);
        assertEquals(userSevice.getUserById(user.getId()).getId(), user.getId());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void userDeleteTest() {
        userSevice.deleteUser(user);
        userSevice.getUserById(user.getId());
    }

    @Test
    public void getUserByEmailAndNameTest() {
        userSevice.registerUser(user);
        assertEquals(userSevice.getUserByEmail(user.getEmail()).getEmail(), user.getEmail());
        assertEquals(userSevice.getUserByName(user.getUserName()).getUserName(), user.getUserName());
    }

    @Test
    public void createEventTest(){
        eventService.createEvent(event);
        assertEquals(eventService.getEventByName(event.getName()).getName(), event.getName());
    }

    @Test
    public void getAllEventsTest() {
        assertEquals(eventService.getAllEvents().get(0).getName(), event.getName());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteEventTest() {
        eventService.deleteEvent(event);
        eventService.getEventByName(event.getName());
    }

    @Test
    public void assighnAuditoriumTest() {
        eventService.assignAuditorium(event, auditorium, new Date());
        assertEquals(event.getAuditorium(), null);
    }

    @Test
    public void getAuditoriumsTest(){
        auditoriumService.addAuditorium(auditorium);
        assertTrue(auditoriumService.getAuditoriums().size() == 1);
    }

    @Test
    public void getTicketsForEventTest() {
        eventService.createEvent(event);
        eventService.assignAuditorium(event, auditorium, new Date());
        event.setTickets(Arrays.asList(ticket_1, ticket_2,ticket_3));
        assertEquals(bookingService.getTicketsForEvent(event,event.getEventDate()),null);
    }

    @Test
    public void setDiscountServiceTest() {
        event.setTickets(Arrays.asList(ticket_1, ticket_2,ticket_3));
        bookingService.bookTicket(user, ticket_1);
        assertTrue(discountService.getDiscountForUser(user,event).getDiscount() == 5);
    }

    @Test
    public void counterAspectTest() {
        assertTrue(!CounterAspect.getCounter().isEmpty());
    }

    @Test
    public void totalDiscountCounterTest() {
        event.setTickets(Arrays.asList(ticket_1, ticket_2,ticket_3));
        bookingService.bookTicket(user, ticket_1);
        discountService.getDiscountForUser(user,event).getDiscount();
        assertTrue(!DiscountAspect.getDiscountTotalCounter().isEmpty());
        assertTrue(!DiscountAspect.getDiscountForUserCounter().get(user.getId()).isEmpty());
    }


}
