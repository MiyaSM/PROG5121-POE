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
    
    //check if user name is not more than 10 characters
    public boolean checkMessageID(){
        return messageID.length() <= 10;
    }
    
    
    
    
            
    
}
