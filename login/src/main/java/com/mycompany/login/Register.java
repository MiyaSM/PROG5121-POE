/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.util.Scanner;

/** 
 *
 * @author miyel
 */
public class Register {
    
   public static void main(String [] args){ 
    Scanner myscanner = new Scanner(System.in);
    Login myLogin = new Login();
    
    //Declare my variable
    String userName;
    String password;
    String cellnumber;
    String firstName;
    String lastName;
    
    
    //ask and collect user inputs
    System.out.print("Enter FirstName: ");
    firstName = myscanner.nextLine();
            
    System.out.print("Enter LastName: ");
    lastName= myscanner.nextLine();
    
    System.out.print("Enter username: ");
    System.out.println("It must contain an under score a number and is no more than 5 character long ");
    userName = myscanner.nextLine();
    
    //check if username meets requirements
            while (!myLogin.checkUserName(userName)) {  
                System.out.println("Username is not correctly formatted; please ensure that your username "
                        + "contains an underscore and is no more than five characters in length.");
                System.out.println("Please enter name again: ");
                userName = myscanner.nextLine();
           
       }
            System.out.println("Username successfully captured.");     
    
    System.out.print("Enter Password: ");
    System.out.print("Password must be lat least 8 charactes long ");
    System.out.print("Password must contain a number ");
    System.out.print("Password must Hve a capital letter and special characters ");
    password = myscanner.nextLine();
    
    
        while (!myLogin.checkPasswordComplexity(password)) { 
            System.out.println("Password is not correctly formated please ensure that the password"
                   + "contains at least eight characters, a capital letter, a number"
                   + "and a special character");
            System.out.println("Please enter Password: ");
            password = myscanner.nextLine();
           
       }
    
    System.out.print("Enter South African phone number e.g(+27123456789");
    cellnumber = myscanner.nextLine();
    //validate cellphone number
       while (!myLogin.checkCellPhoneNumber(cellnumber)) {  
           System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
           cellnumber = myscanner.nextLine(); 
       }
       System.out.println("Cell phone number successfully added.");
       
        // Register user and output result
        String registered = myLogin.registerUser(userName, password, cellnumber, firstName, lastName);
        System.out.println("\n" + registered);
        
        
        //user loging in
        System.out.println("Enter username");
        String loginName = myscanner.nextLine();
        
        System.out.println("Enter Password");
        String myPass = myscanner.nextLine();
             
      
       // Process authentication
       boolean isloggedIn = myLogin.loginUser(loginName, myPass);
       String Status = myLogin.returnLoginStatus(isloggedIn);
       
       System.out.println("\n" + Status);

        /////////////// PART 2 ///////////////////////////////////                              
        //The user would only move to the second stage if they have successfuly loged in
        if(isloggedIn){
        System.out.println("Welcome to QuickChat.");
        
        
       boolean Active = true;
       Messages msgObject = new Messages();
       // used a while loop it will display menue option until the user
       // desides to quit
       while (Active) {  
            System.out.println("\n1) Send message");
            System.out.println("2) Show recently sent messages coming soon");
            System.out.println("3) Quit");
            System.out.println("Choose an option 1 to 3");
     
            int number = myscanner.nextInt();
            myscanner.nextLine(); // consume newline
      
        switch(number) {
            case 1:
                //ask user how many messages they want to send
                System.out.print("How many messages would you like to enter? ");
                int Messagecount = myscanner.nextInt();
                myscanner.nextLine(); // consume newline
                
             // the loop will loop trough the amount of times the user want to 
             //enter ther message
            for(int i = 1; i <= Messagecount; i++){
                System.out.println("Message " + i + " of " + Messagecount + " ---");
                
                 
                System.out.print("Enter Message ID (max 10 characters): ");
                String MessageID = myscanner.nextLine();
                 
                System.out.print("Enter Recipient Cell Number (format +27XXXXXXXXX): ");
                String recipientCell = myscanner.nextLine();
                System.out.println(msgObject.checkRecipientCell(recipientCell));
                 
                System.out.println("Enter Message (max 250 characters): ");
                String Message = myscanner.nextLine();
                 
                if (Message.length() <= 250) {
                    System.out.println("Message sent"); 
                } else {
                    System.out.println("Please enter a message of less than 250 characters.");
                }
                 
                System.out.println("\nChoose action:");
                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message to send later");
                int Choice = myscanner.nextInt();
                myscanner.nextLine(); // consume newline - crucial to prevent skipping!
                 
                System.out.println(msgObject.sentMessage(Choice));
             
                if (Choice == 1 || Choice == 3){
                    System.out.println(msgObject.printMessages());
                }
            }
             //display the toatal amount of messages sent
                System.out.println("\nTotal messages processed: " + msgObject.returnTotalMessages());
                 break;
            
            case 2:
                System.out.println("Coming Soon.");
                break;

            case 3:
                System.out.println("Exiting QuickChat. Goodbye!");
                Active = false;
                break;
    
            default:
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
    }
}
        
                     
        }        
            }
                    
                   }
                      
                 
                       
                   
               
           
         
         
       
 
 
      
       

   
