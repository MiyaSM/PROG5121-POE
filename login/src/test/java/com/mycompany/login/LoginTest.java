/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

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
        
    
}
