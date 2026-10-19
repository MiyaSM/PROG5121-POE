
package com.mycompany.login;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;




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
    // used setter methods so i can store information inside the object and display it later
   public void setMessageID(String messageID){
        this.messageID = messageID;
    }

    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setMessageHash(String messagehash){
        this.messagehash = messagehash;
    } 
    //check if user name is not more than 10 characters
    public boolean checkMessageID(){
        return messageID.length() <= 10;
    }
    
 
    
    public String checkRecipientCell(String cellNumber){
    //CALLING THE checkCellPhoneNumber Method from the login class
        Login LoginObj = new Login();
       
        if (LoginObj.checkCellPhoneNumber(cellNumber)){
            return "Cell phone number successfully captured";} else {
        return "Cell phone number is incorrectly formitted or does not"
                + " contain an international code. Please correct the number and "
                + "try again"; }
    }
    
    // Method to create a unique hash for the message
    public String createMessageHash(String MsgID, int messageNumber,String messages){
        String[] messageword = messages.trim().split("\\s+");
        String Fistword = "";
        String Lastword = "";
        // Check if the message has words to prevent out-of-bounds errors
        if(messageword.length > 0){
        Fistword = messageword[0];
        Lastword = messageword[messageword.length - 1];
        }
        // Combine the first two letters of the ID, message number, and uppercase words to create the hash
         messagehash= MsgID.substring(0, 2) + ":" + messageNumber + ":" + (Fistword + Lastword).toUpperCase();
         return messagehash;
    }
    
   
    public String sentMessage(int choice){
        //using a case statement
     switch (choice){
         case 1:
             totalMessages++;
             return "Message successfully sent";
             
         case 2:
             return "Press 0 to delete the message";
             
         case 3 :
             // Stores the message in a JSON file
             storeMessage();
             return "Message successfully stored";
             
         default:
             return "Invalid option";
          
        }
    } 
    
     //methode returns all messages sent
        public String printMessages(){
            return "Message ID: " + messageID +
                    "\nMessage Hash " + messagehash 
                    + "\nRecipient: " + recipient + 
                    "\nMessage: "+ message ;
                
    }
        
        public int returnTotalMessages(){
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
            
     
               
}
       
       
        
    
    
    
    
    
            
    
}
