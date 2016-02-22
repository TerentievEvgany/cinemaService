package com.epam.courses.springcore;

import com.epam.courses.aop.aspects.CounterAspect;
import com.epam.courses.aop.aspects.DiscountAspect;
import com.epam.courses.springcore.pojo.*;
import com.epam.courses.springcore.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
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
    private Auditorium auditorium;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private DiscountService discountService;

    private User user = new User(1, "Test", "test@mail.com", new Date());
    private Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
    private Ticket ticket_1 = new Ticket(new BigDecimal(75), 10);
    private Ticket ticket_2 = new Ticket(new BigDecimal(75), 11);
    private Ticket ticket_3= new Ticket(new BigDecimal(75), 12);

    @Test
    public void userRegistrationTest() {
        userSevice.registerUser(user);
        assertEquals(userSevice.getUserById(user.getId()), user);
    }

    @Test
    public void userDeleteTest() {
        userSevice.registerUser(user);
        userSevice.deleteUser(user);
        assertEquals(userSevice.getUserById(user.getId()), null);
    }

    @Test
    public void getUserByEmailAndNameTest() {
        userSevice.registerUser(user);
        assertEquals(userSevice.getUserByEmail(user.getEmail()), user);
        assertEquals(userSevice.getUserByName(user.getUserName()), user);
    }

    @Test
    public void createEventTest(){
        eventService.createEvent(event);
        assertEquals(eventService.getEventByName(event.getName()), event);
    }

    @Test
    public void getAllEventsTest() {
        eventService.createEvent(event);
        assertEquals(eventService.getAllEvents(), Arrays.asList(event));
    }

    @Test
    public void deleteEventTest() {
        eventService.createEvent(event);
        eventService.deleteEvent(event);
        assertTrue(eventService.getAllEvents().isEmpty());
    }

    @Test
    public void assighnAuditoriumTest() {
        eventService.createEvent(event);
        eventService.assignAuditorium(event, auditorium, new Date());
        assertEquals(event.getAuditorium(), auditorium);
    }

    @Test
    public void getAuditoriumsTest(){
        assertTrue(auditoriumService.getAuditoriums().size() == 1);
    }

    @Test
    public void getTicketsForEventTest() {
        eventService.createEvent(event);
        eventService.assignAuditorium(event, auditorium, new Date());
        event.setTickets(Arrays.asList(ticket_1, ticket_2,ticket_3));
        assertEquals(bookingService.getTicketsForEvent(event,event.getEventDate()), Arrays.asList(ticket_1, ticket_2,ticket_3));
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
