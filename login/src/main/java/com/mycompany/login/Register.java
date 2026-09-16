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
    String UserName;
    String Password;
    String cellnumber;
    String FirstName;
    String LastName;
    
    
    //ask and collect user inputs
    System.out.print("Enter FirstName");
    FirstName = myscanner.nextLine();
            
    System.out.print("Enter LastName");
    LastName= myscanner.nextLine();
    
    System.out.print("Enter username");
    System.out.println("It must contain an under score and is no more than 5 character long ");
    UserName = myscanner.nextLine();
    
    System.out.print("Enter last Password");
    System.out.print("Password must be lat least 8 charactes long ");
    System.out.print("Password must contain a number ");
    System.out.print("Password must Hve a capital letter and special characters ");
    Password = myscanner.nextLine();
    
    System.out.print("Enter South African phone number e.g(+27123456789");
    cellnumber = myscanner.nextLine();

    //validate cellphone number
       while (!myLogin.checkCellPhoneNumber(cellnumber)) {  
           System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
           cellnumber = myscanner.nextLine(); 
       }
       System.out.println("Cell phone number successfully added.");
       
        // Register user and output result
        String registered = myLogin.registerUser(UserName, Password, cellnumber, FirstName, LastName);
        System.out.println("\n" + registered);
        
        // Terminate if registration failed
        if (!registered.contains("You have been successfully registered")){
        System.out.println("Registration failed. Please restart and try again.");
        return;
        }
        //user loging in
        System.out.println("Enter username");
        String loginName = myscanner.nextLine();
        
        System.out.println("Enter Password");
        String myPass = myscanner.nextLine();
             
      
       // Process authentication
       boolean isloggedIn = myLogin.loginUser(loginName, myPass);
       String Status = myLogin.returnLoginStatus(isloggedIn);
       
       System.out.println("\n" + Status);

  

   }    
       
}
   
