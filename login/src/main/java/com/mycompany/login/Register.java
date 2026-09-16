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
    
    
    //ask and collect user inputs
    
    System.out.print("Enter username");
    System.out.println("It must contain an under score and is no more than 5 character long ");
    UserName = myscanner.nextLine();
    
    System.out.print("Enter last Password");
    System.out.println("Password must be lat least 8 charactes long ");
    System.out.println("Password must contain a number ");
    System.out.println("Password must Hve a capital letter and special characters ");
    Password = myscanner.nextLine();
    
    System.out.print("Enter South African phone number e.g(+27123456789");
    cellnumber = myscanner.nextLine();
    
    
   
    
    
    
    
    
    
  
    
    
    
   }   
}
