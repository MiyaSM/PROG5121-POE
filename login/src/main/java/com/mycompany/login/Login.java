/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author miyel
 */
public class Login {
    //login class contains methode codes 
   
        // Fields to store user information
        private String registeredUsername;
        private String registeredPassword;
        private String registeredCellNumber;
        private String firstName;
        private String lastName;
        
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
            boolean number = false;
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
                number = true;
            }
           }
            return capitalChar && number && specialChar;
              
        }
        //This method ensures that the cell phone is the correct length and contains the international country code.
        
        public boolean checkCellPhoneNumber(String cellPhoneNumber){
            if (cellPhoneNumber == null){
            return false;
        }
            /*** Validates South African cell phone numbers with international prefix (+27).
            * @see <a href="https://stackoverflow.com/questions/33477950/java-regex-phone-number">StackOverflow Regex Reference</a>
           */
            String regex = "^\\+27\\d{9}$";
        return cellPhoneNumber.matches(regex);
        }
        
        public String registerUser(String username, String password, String cellNumber, String fName, String lName){
        //validate userName
        
        if (!checkUserName(username)){
            
            return "Username is not correctly formatted; please ensure that your username contains " 
                    + "an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)){
           return "Password is not correctly formatted; please ensure that the password "
                   + "contains at least eight characters, a capital letter, a number, "
                   + "and a special character.";
                   
        }
        
        registeredUsername = username;
        registeredPassword = password;
        registeredCellNumber = cellNumber;
        firstName =fName;
        lastName = lName;
        
        return "Password successfully captured.";
      
        }
        //This method verifies that the login details entered match the login details stored when the user registers.
        public boolean loginUser(String userName, String password){
            return registeredUsername != null && registeredUsername.equals(userName)&& registeredPassword.equals(password);
        }
        
        //This method returns the necessary messaging for:A successful login and A failed login

        public  String returnLoginStatus(boolean loggedIn){
        if (loggedIn){
            return "Welcome " +firstName+" " + lastName+ ", it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }  
        }
            
                
             

        
        
        
        
        
        
         
        
        
        
        
        
        
        
        
        
        
        

        
        
    
}
