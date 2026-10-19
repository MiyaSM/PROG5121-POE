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

    // --- MESSAGE HASH TESTS ---

   @Test
    public void testCreateMessageHash() {
    Messages msg = new Messages();
    String expectedHash = "ID:1:HELLOWORLD";
    String actualHash = msg.createMessageHash("ID01", 1, "Hello world");
    assertEquals(expectedHash, actualHash);
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