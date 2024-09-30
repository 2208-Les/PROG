/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectFormat() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
        assertEquals("Welcome <user first name> ,<user last name> it is great to see you.", login.returnLoginStatus(true));
    }

    @Test
    public void testUsernameIncorrectFormat() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyle!!!!!!!"));
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", 
                     login.registerUser("kyle!!!!!!!", "Password1!", "First", "Last"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertEquals("Password successfully captured", "Password successfully captured");
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.",
                     "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
    }

    @Test
    public void testLoginSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kylie", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailure() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kylie", "Smith");
        assertFalse(login.loginUser("wrong_user", "wrong_password"));
    }
}

