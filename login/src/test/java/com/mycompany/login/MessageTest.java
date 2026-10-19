/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miyel
 */
package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Messages class (Part 2)
 *
 * @author miyel
 */
public class MessageTest {
    
    
    ///question 8

    // QUESTION 8 TESTS: Testing Specific Rubric Test Data Cases

    
    @Test
    public void TestDataCase1() {
        Messages msg = new Messages();
        
        // 1. Test recipient number from rubric test data
        String recipient = "+27718693002";
        assertEquals("Cell phone number successfully captured", msg.checkRecipientCell(recipient));
        msg.setRecipient(recipient);
        
        String messageText = "Hi Mike, can you join us for dinner tonight";
        assertTrue(messageText.length() <= 250);
        msg.setMessage(messageText);
        
        // 3. Test hash generation for test case 1 (Message number 1)
        String hash = msg.createMessageHash("1234567890", 1, messageText);
        assertEquals("12:1:HITONIGHT", hash);
        
        
        assertEquals("Message successfully sent", msg.sentMessage(1));
    }

    // Test 2: Rubric Test Data Message 2 
    public void TestMessage2Case() {
        Messages msg = new Messages();
        
        // 1. Test invalid recipient cell number 
        String invalidRecipient = "0857975889";
        // Matches the exact spelling currently present in the Messages class return string
        String expectedError = "Cell phone number is incorrectly formitted or does not contain an international code. Please correct the number and try again";
        assertEquals(expectedError, msg.checkRecipientCell(invalidRecipient));
        
        // 2. Test message text for message 2
        String messageText = "Hi Keegan, did you receive the payment";
        assertTrue(messageText.length() <= 250);
        msg.setMessage(messageText);
        
        // 3. Test choosing option 2 
        assertEquals("Press 0 to delete the message", msg.sentMessage(2));
    }

    
                                             //question 9
    
    // Test 1: Verify message length check 
    @Test
    public void testCheckMessageLength() {
        Messages msg = new Messages();
        
        // Define a valid message text
        String validMsg = "Hello, this is a valid test message.";
        
        // Assert that the length is less than or equal to 250 characters
        assertTrue(validMsg.length() <= 250, "Message should be under 250 characters");
    }

    // Test 2: Verify recipient cell phone number formatting and validation
    @Test
    public void testCheckRecipientCell() {
        Messages msg = new Messages();
        
        // Test with a valid South African international code format
        String result = msg.checkRecipientCell("+27831234567");
       
        assertEquals("Cell phone number successfully captured", result);
    }

    // Test 3: Verify unique message hash creation
    @Test
    public void testCreateMessageHash() {
        Messages msg = new Messages();
        
        // Test data provided by project specifications
        String msgID = "1234567890";
        int messageNumber = 0;
        String messageText = "Hi tonight";
        
        // Generate the hash and compare it against the expected format
        String hash = msg.createMessageHash(msgID, messageNumber, messageText);
        assertEquals("12:0:HITONIGHT", hash);
    }

    // Test 4: Verify message action menu choices (Send, Disregard, Store)
    @Test
    public void testSentMessageChoices() {
        Messages msg = new Messages();
        
        // Test Choice 1: Sending message should increment total and confirm success
        assertEquals("Message successfully sent", msg.sentMessage(1));
        
        assertEquals("Press 0 to delete the message", msg.sentMessage(2));
       
       
        assertEquals("Message successfully stored", msg.sentMessage(3));
    }
    // --- MESSAGE LENGTH TESTS ---

    @Test
    public void testMessageLengthSuccess() {
        String message = "Hi Mike, can you join us for dinner tonight?";
        assertTrue(message.length() <= 250, "Message under 250 characters should be valid.");
    }

    @Test
    public void testMessageLengthFailure() {
        String message = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertFalse(message.length() <= 250, "Message over 250 characters should be invalid.");
    }

    // --- RECIPIENT CELL PHONE TESTS ---

    @Test
    public void testRecipientSuccess() {
        Messages msg = new Messages();
        String expected = "Cell phone number successfully captured";
        String actual = msg.checkRecipientCell("+27718693002");
        assertEquals(expected, actual, "Valid cell number with +27 should pass.");
    }

    @Test
    public void testRecipientFailure() {
        Messages msg = new Messages();
        String expected = "Cell phone number is incorrectly formitted or does not contain an international code. Please correct the number and try again";
        String actual = msg.checkRecipientCell("08575975889");
        assertEquals(expected, actual, "Cell number without +27 or incorrect format should fail.");
    }
   

    // --- MENU / SENT MESSAGE OPTION TESTS ---

    @Test
    public void testSendMessage() {
        Messages msg = new Messages();
        assertEquals("Message successfully sent", msg.sentMessage(1), "Choice 1 should return success message.");
    }

    @Test
    public void testDisregardMessage() {
        Messages msg = new Messages();
        assertEquals("Press 0 to delete the message", msg.sentMessage(2), "Choice 2 should prompt to delete.");
    }

    @Test
    public void testStoreMessage() {
        Messages msg = new Messages();
        assertEquals("Message successfully stored", msg.sentMessage(3), "Choice 3 should return storage message.");
    }
    
    
    
}