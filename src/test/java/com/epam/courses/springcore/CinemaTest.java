package com.epam.courses.springcore;

import com.epam.courses.aop.aspects.CounterAspect;
import com.epam.courses.springcore.pojo.*;
import com.epam.courses.springcore.services.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Unit test for simple Cinema Service.
 */
public class CinemaTest {

    private User user = new User(1, "Test", "test@mail.com", new Date());
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    private UserSevice userSevice = (UserSevice) ctx.getBean("userService");
    private EventService eventService = (EventService) ctx.getBean("eventService");
    private Event event = new Event("First", Rating.HIGH, new BigDecimal(50), new Date());
    private Auditorium auditorium = ctx.getBean(Auditorium.class);
    private AuditoriumService auditoriumService = ctx.getBean(AuditoriumService.class);
    private BookingService bookingService = ctx.getBean(BookingService.class);
    private DiscountService discountService = ctx.getBean(DiscountService.class);
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
        assertTrue(discountService.getDiscountForUser(user,event).equals(new BigDecimal(0)));
        discountService.getStrategies().get(0).getDiscount();
    }

    @Test
    public void aspectTest() {
        assertTrue(!CounterAspect.getCounter().isEmpty());
    }

}
