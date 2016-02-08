package com.epam.courses.springcore;

import com.epam.courses.springcore.pojo.User;
import com.epam.courses.springcore.services.UserSevice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
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

}
