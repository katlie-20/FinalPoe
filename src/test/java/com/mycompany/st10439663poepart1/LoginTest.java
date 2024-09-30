/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10439663poepart1;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login user1 = new Login("user_", "TestPassword1!");
        assertTrue(user1.checkUserName());

        Login user2 = new Login("username", "TestPassword1!");
        assertFalse(user2.checkUserName());

         Login user3 = new Login("u_r", "TestPassword1!");
        assertFalse(user3.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login user1 = new Login("user_", "Pass1@word");
        assertTrue(user1.checkPasswordComplexity());

        Login user2 = new Login("user_", "password");
        assertFalse(user2.checkPasswordComplexity());

        Login user3 = new Login("user_", "Password1");
        assertFalse(user3.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUser() {
        Login user1 = new Login ("test_", "TestPassword1!");
        assertEquals("Registration successful!", user1.registerUser());

        Login user2 = new Login("testName", "TestPassword1!");
        assertEquals("Invalid username format. Must contain an underscore (_) and be no more than 5 characters.", user2.registerUser());

        Login user3 = new Login("test_", "password");
        assertEquals("Invalid password format. Must be at least 8 characters long and contain a capital letter, a number, and a special character.", user3.registerUser());
    }

    @Test
    public void testLoginUser() {
        Login Loginnew;
         Login user = Loginnew Login("test_", "TestPassword1!");
        assertTrue(user.loginUser("test_", "TestPassword1!"));
       
        assertFalse(user.loginUser("test_", "wrong_password"));
        assertFalse(user.loginUser("wrong_username", "TestPassword1!"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login user = new Login("test_", "TestPassword1!");
        assertEquals("Login successful!", user.returnLoginStatus(true));
        assertEquals("Login failed. Please check your username and password and try again.", user.returnLoginStatus(false));
    }
}

    
   