/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

import java.util.Scanner;

/**
 *
 * @author miyel
 */
public class Login {

   
        // Fields to store user information
        private String registeredUsername;
        private String registeredPassword;
        private String registeredCellNumber;
        
        //check if the user name iS NOT an "" ,that it contains Letters a number and special characters
        public boolean checkUserName(String userName){
            return !userName.equals("") && userName.contains("_") && userName.length() <= 5;
        }
        
        //Check if passord has 8 characters a capital letter ,special characters and a number
        public boolean checkPasswordComplexity(String password){
            if (password.equals("") || password.length() < 8){
               return false;  
            }
           
            boolean capitalChar = false;
            boolean Number = false;
            boolean specialChar = false;
            
            //used a for loop to check each character in the password
            for (int i =0; i < password.length(); i++){
                char pass = password.charAt(i);
            
            //check if it has an uppercase letter
            if (Character.isUpperCase(pass)){
                capitalChar = true;
            }
            // chck if it contain special character
           if (!Character.isLetterOrDigit(pass)) {
                specialChar = true;
            }
           //check if it has a number
            if(Character.isDigit(pass)){
                Number = true;
            }
           }
            return capitalChar && Number && specialChar;
              
        }
        //This method ensures that the cell phone is the correct length and contains the international country code.
        
         
        
        
        
        
        
        
        
        
        
        
        

        
        
    
}
