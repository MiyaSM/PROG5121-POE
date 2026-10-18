/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miyel
 */
public class Messages {
    
    private String messageID;
    private String recipient;
    private String message;
    private String messagehash;
    
    private static int totalMessages = 0;
    
    //check if user name is not more than 10 characters
    public boolean checkMessageID(){
        return messageID.length() <= 10;
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
             return "Message successfully stored";
             
         default:
             return "Invalid option";
          
        }
    } 
    
     //methode returns all messages sent
        String printMessages(){
            return "Message ID:" + messageID + "\nMessage Hash" + messagehash + "\nMessage: "
                + message;
    }
        
        public int returnTotalMessages(){
            return totalMessages;
            
        
        }
    
    
    
    
    
            
    
}
