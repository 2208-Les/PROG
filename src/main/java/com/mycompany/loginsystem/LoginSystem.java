/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class LoginSystem {

    public static void main(String[] args) {
        //Predefined username and password
        final String CORRECT_USERNAME = "admin";
        final String CORRECT_PASSWORD = "password123";
        
        //Maximum number of login attempts
        final int MAX_ATTEMPTS = 5;
        
        //Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        //Variable to keep track of the number of attempts
        int attempts = 0;
        boolean accessGranted = false;
        
        //Loop to give the user up to MAX_ATTEMPTS to enter correct credentials
        while (attempts < MAX_ATTEMPTS) {
            //Prompt user to enter their username
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            
            //Prompt user to enter their password
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();
            
            //check if the entered username and password match the predefined ones
            if (enteredUsername.equals(CORRECT_USERNAME) && enteredPassword.equals(CORRECT_PASSWORD)) {
                
                //if both username and password match
                System.out.println("Congrulations, you have been granted access.");
                accessGranted = true;   //Set the flag to true to exit the loop
                break;  //Exit the loop
            }else{
                //If either username or password does not match 
                attempts++; //Increment the number of attempts
                System.out.println("Incorrect username or password. You have " + (MAX_ATTEMPTS - attempts) + "attempt(s) left.");
            }
        }
        
        //Check if the user has exhausted all atempts without success
        if (!accessGranted) {
            System.out.println("You have exceeded your attempts.");
        }
        
        //Close the scanner object
        scanner.close();
    }
}
