
package com.mycompany.login;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miyel
 */


public class Messages {

    //stores message details
    private String messageID;
    private String recipient;
    private String message;
    private String messagehash;

    //will contain the total messages sent
    private static int totalMessages = 0;

    // Part 3 arrays
    
// Stores all sent messages
    private static String[] sentMessages = new String[100];

// Stores all disregarded messages
    private static String[] disregardedMessages = new String[100];

// Stores all stored messages
    private static String[] storedMessages = new String[100];

// Stores all message hashes
    private static String[] messageHashes = new String[100];

// Stores all message IDs
    private static String[] messageIDs = new String[100];
    // Stores recipients
private static String[] recipients = new String[100];

// Keeps track of array positions
    private static int sentCount = 0;
    private static int disregardedCount = 0;
    private static int storedCount = 0;

    // used setter methods so i can store information inside the object and display it later
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageHash(String messagehash) {
        this.messagehash = messagehash;
    }

    //check if user name is not more than 10 characters
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public String checkRecipientCell(String cellNumber) {
        //CALLING THE checkCellPhoneNumber Method from the login class
        Login LoginObj = new Login();

        if (LoginObj.checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number successfully captured";
        } else {
            return "Cell phone number is incorrectly formitted or does not"
                    + " contain an international code. Please correct the number and "
                    + "try again";
        }
    }

    // Method to create a unique hash for the message
    public String createMessageHash(String MsgID, int messageNumber, String messages) {
        String[] messageword = messages.trim().split("\\s+");
        String Fistword = "";
        String Lastword = "";
        // Check if the message has words to prevent out-of-bounds errors
        if (messageword.length > 0) {
            Fistword = messageword[0];
            Lastword = messageword[messageword.length - 1];
        }
        // Combine the first two letters of the ID, message number, and uppercase words to create the hash
        messagehash = MsgID.substring(0, 2) + ":" + messageNumber + ":" + (Fistword + Lastword).toUpperCase();
        return messagehash;
    }

    public String sentMessage(int choice) {
        //using a case statement
        switch (choice) {
            case 1:
                totalMessages++;
                
                // Part 3: add sent message details to arrays
                sentMessages[sentCount] = message;
                messageHashes[sentCount] = messagehash;
                messageIDs[sentCount] = messageID;
                recipients[sentCount] = recipient;

                sentCount++;
                
                return "Message successfully sent";

            case 2:
                // Stores disregarded messages
                disregardedMessages[disregardedCount] = message;

                disregardedCount++;
                return "Press 0 to delete the message";

            case 3:
                // Stores messages that were saved
                storedMessages[storedCount] = message;

                storedCount++;

                // Stores the message in JSON
                storeMessage();
                return "Message successfully stored";

            default:
                return "Invalid option";

        }
    }

    //methode returns all messages sent
    public String printMessages() {
        return "Message ID: " + messageID
                + "\nMessage Hash " + messagehash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;

    }

    public int returnTotalMessages() {
        return totalMessages;

    }
    //store the messages in a jason file

    public void storeMessage() {
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("messageID", messageID);
        jsonMessage.put("messageHash", messagehash);
        jsonMessage.put("recipient", recipient);
        jsonMessage.put("message", message);

        // 2. Write the JSON object to a file
        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(jsonMessage.toString(4));
            file.write("\n");
            System.out.println("Message successfully stored to JSON file.");
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
            //code geeks for geeks       
        }//code from <a href ="https://www.geeksforgeeks.org/java/working-with-json-data-in-java/> jsaon file<a/>

      //////////////////////////////////////////////////////////////////////////
     // Part 3
}/////////////////////////////////////////
    
    // Displays all stored messages and their recipients

 
    public void displayStoredMessages() {

        System.out.println("\nStored Messages:");

        for (int i = 0; i < storedCount; i++) {

            // Displays recipient and stored message
            System.out.println("Recipient: " + recipients[i]);
            System.out.println("Message: " + storedMessages[i]);
            System.out.println("-------------------");
        }
    }


    // Finds and returns the longest stored message
    public String longestMessage() {

        String longest = "";

        for (int i = 0; i < storedCount; i++) {

            if (storedMessages[i] != null
                    && storedMessages[i].length() > longest.length()) {

                longest = storedMessages[i];
            }
        }

        return longest;
    }

    // Searches for a message using its Message ID
    public String searchMessageID(String searchID) {

        for (int i = 0; i < sentCount; i++) {

            if (messageIDs[i] != null
                    && messageIDs[i].equals(searchID)) {

                return "Message Found: " + sentMessages[i];
            }
        }

        return "Message ID not found.";
    }

    // Searches for all messages sent to a specific recipient
    public String searchRecipient(String searchRecipient) {

        String results = "";

        for (int i = 0; i < sentCount; i++) {

            if (recipients[i] != null
                    && recipients[i].equals(searchRecipient)) {

                results = results + sentMessages[i] + "\n";
            }
        }

        if (results.isEmpty()) {
            return "No messages found for this recipient.";
        }

        return results;
    }
    
    // Deletes a message using its hash
    public String deleteMessageHash(String hash) {

        for (int i = 0; i < sentCount; i++) {

            if (messageHashes[i] != null
                    && messageHashes[i].equals(hash)) {

                String deletedMessage = sentMessages[i];

                sentMessages[i] = null;
                messageHashes[i] = null;
                messageIDs[i] = null;

                return "Message \"" + deletedMessage
                        + "\" successfully deleted.";
            }
        }

        return "Message hash not found.";
    }

    // Displays a report of all sent messages
    public String displayReport() {

        String report = "";

        for (int i = 0; i < sentCount; i++) {

            if (sentMessages[i] != null) {

                report = report + "\nMessage ID: " + messageIDs[i];
                report = report + "\nMessage Hash: " + messageHashes[i];
                report = report + "\nMessage: " + sentMessages[i];

            }
        }

        return report;
    }
    // Reads messages from the JSON file and loads them into arrays

    public void loadMessagesFromJSON() {

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader("messages.json"));

            String line;

            while ((line = reader.readLine()) != null) {

                JSONObject obj = new JSONObject(line);

                storedMessages[storedCount]
                        = obj.getString("message");

                messageIDs[storedCount]
                        = obj.getString("messageID");

                messageHashes[storedCount]
                        = obj.getString("messageHash");

                recipients[storedCount]
                        = obj.getString("recipient");

                storedCount++;
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error reading JSON file: "
                    + e.getMessage());
        }
    }

    // Displays messages loaded from JSON
    public void displayJSONMessages() {

        System.out.println("\nMessages loaded from JSON:");

        for (int i = 0; i < storedCount; i++) {

            System.out.println("Message ID: "
                    + messageIDs[i]);

            System.out.println("Recipient: "
                    + recipients[i]);

            System.out.println("Message: "
                    + storedMessages[i]);

            
        }
    }


}
