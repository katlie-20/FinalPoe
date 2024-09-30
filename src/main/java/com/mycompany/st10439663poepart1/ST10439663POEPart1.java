/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10439663poepart1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class ST10439663POEPart1 {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.println("\tRegistration: ");

        // Get user's name and surname
        System.out.print("\tEnter Name: ");
        String name = input.next();
        
        System.out.print("\tEnter Surname: ");
        String surname = input.next();

        String username = "";
        String password = "";
        boolean isRegistered = false;

        //validate username and password
        while (!isRegistered) {
            System.out.print("\nEnter a username (5 or fewer characters, containing an underscore): ");
            username = input.next();
            
            System.out.print("Enter a password (8 or more characters, containing a digit, capital letter, and special character): ");
            password = input.next();

            // Create a new Login object with the entered credentials
            Login user = new Login(username, password);
            String registrationStatus = user.registerUser();

            // Check if registration was successful
            if (registrationStatus.contains("successful")) {
                isRegistered = true; // Exit loop if registration is successful
                System.out.println("\n" + registrationStatus);
            } else {
                System.out.println("\nRegistration failed. " + registrationStatus);
            }
        }

        boolean isLoggedIn = false;
        // Create user object with valid credentials for login
        Login user = new Login(username, password);

        // Loop for login attempts
        while (!isLoggedIn) {
            System.out.print("Enter your username to login: ");
            String inputUsername = input.next();
            System.out.print("Enter your password: ");
            String inputPassword = input.next();

            // Check login status
            boolean loginStatus = user.loginUser(inputUsername, inputPassword);
            System.out.println(user.returnLoginStatus(loginStatus));

            // Set login status based on credentials
            if (loginStatus) {
                isLoggedIn = true;
            } else {
                System.out.println("Please try again.");
            }
        }

        // Welcome message after successful login
        System.out.println("Welcome " + name + " " + surname + ", it is great to see you again!");
    }
}
    

