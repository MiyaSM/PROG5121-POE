/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author miyel
 */
public class LoginTest {
 
    //TestUsername
    @Test
    public void testCheckUserNameCorrecrtFormate(){
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"), "Username containing '_' and <= 5 chars should be valid.");
    }
    @Test
    public void testCheckUserNameIncorrectFormat() {
        Login login = new Login();
        // Invalid: Length > 5
        assertFalse(login.checkUserName("kyle_smith"), "Username over 5 characters should be invalid.");
    }
    
    @Test
    public void testCheckPasswordComplexitySuccess() {
        Login login = new Login();
        // Valid: Meets length, uppercase, number, and special character requirements
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"), "Password meeting all complexity rules should return true.");
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        Login login = new Login();
        // Invalid: Lacks uppercase and special characters
        assertFalse(login.checkPasswordComplexity("password"), "Simple password without caps/special chars should return false.");
    }

    // --- CELL PHONE NUMBER TESTS ---

    @Test
    public void testCheckCellPhoneNumberSuccess() {
        Login login = new Login();
        // Valid: SA format starting with +27 followed by 9 digits
        assertTrue(login.checkCellPhoneNumber("+27831234567"), "Valid SA cellphone number with +27 prefix should return true.");
    }

    @Test
    public void testCheckCellPhoneNumberFailure() {
        Login login = new Login();
        // Invalid: Missing country code
        assertFalse(login.checkCellPhoneNumber("0831234567"), "Number without international prefix +27 should return false.");
    }

    // --- REGISTRATION RETURN STRING TESTS ---

    @Test
    public void testRegisterUserSuccess() {
        Login login = new Login();
        String expected = "Password successfully captured.";
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567", "John", "Doe");
        assertEquals(expected, actual, "Registration with valid data must return success message.");
    }

    @Test
    public void testRegisterUserUsernameFailure() {
        Login login = new Login();
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle_smith", "Ch&&sec@ke99!", "+27831234567", "John", "Doe");
        assertEquals(expected, actual, "Invalid username must trigger exact rubric error message.");
    }

    @Test
    public void testRegisterUserPasswordFailure() {
        Login login = new Login();
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = login.registerUser("kyl_1", "password", "+27831234567", "John", "Doe");
        assertEquals(expected, actual, "Invalid password must trigger exact rubric error message.");
    }

    // --- LOGIN & AUTHENTICATION STATUS TESTS ---

    @Test
    public void testLoginUserSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567", "John", "Doe");
        
        // Matching credentials
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"), "Login should return true for matching credentials.");
    }

    @Test
    public void testLoginUserFailure() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567", "John", "Doe");
        
        // Mismatched credentials
        assertFalse(login.loginUser("kyl_1", "WrongPass123!"), "Login should return false for incorrect password.");
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567", "John", "Doe");
        
        String expected = "Welcome John Doe, it is great to see you.";
        String actual = login.returnLoginStatus(true);
        assertEquals(expected, actual, "Successful login status string must match rubric greeting.");
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        
        String expected = "Username or password incorrect, please try again.";
        String actual = login.returnLoginStatus(false);
        assertEquals(expected, actual, "Failed login status string must match rubric failure message.");
    }
    
        
    
}
