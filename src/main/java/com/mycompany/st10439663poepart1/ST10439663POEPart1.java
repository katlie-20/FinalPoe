/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10439663poepart1;

import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class ST10439663POEPart1 {

    public static void main(String[] args) {
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
       String welcome;
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
       
    String welcomeMessage ="Welcome to Easy KanBan.";
    JOptionPane.showMessageDialog(null,welcomeMessage);
    
    boolean exit = false;
    
    while(!exit){
        //Show the menu to select options
        String menu = "please choose an option:\n" + "1.Add task\n"+ "2.Show report\n" + "3.Quit";
        String choice = JOptionPane.showInputDialog(menu);
        
        switch(choice){
            case "1":
                AddTasks();
            break;
            
            case "2":
                JOptionPane.showMessageDialog(null,"Coming soon");
                
            case "3":
                exit = true;
                break;
            default:
                
            JOptionPane.showMessageDialog(null,"Please enter options 1 - 3");
            break;
            }
        }
    }
      // Method to add tasks
    public static void AddTasks() {
        String taskCountStr = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        int taskCount = Integer.parseInt(taskCountStr);

        for (int i = 1; i <= taskCount; i++) {
            // Collect task information
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");

            // Limit description to 50 characters
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Task description cannot exceed 50 characters.");
                taskDescription = taskDescription.substring(0, 50);
            
            }

            String developerFirstNameAndLastName = JOptionPane.showInputDialog("Enter Developer First Name and Last Name:");
            String taskDurationStr = JOptionPane.showInputDialog("Enter Task Duration in hours:");
            int taskDuration = Integer.parseInt(taskDurationStr);

            // Task ID creation
            String taskID = "TK" + i;

            // Task status dropdown
            String[] taskStatusOptions = {"To Do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:",
                    "Task Status", JOptionPane.QUESTION_MESSAGE, null, taskStatusOptions, taskStatusOptions[0]);
        }
    }
        // printing of the task details
    public String printTaskDetails() {
        String taskName = null;
        String taskNumber = null;
        String taskDescription = null;
        String developerDetails = null;
        String taskDuration = null;
        String taskStatus = null;
        String taskID = null;
        return "Task Name: " + taskName + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Duration: " + taskDuration + "\n" +
               "Task Status: " + taskStatus + "\n" +
               "Task ID: " + taskID + "hrs\n"; 
    }
 }



