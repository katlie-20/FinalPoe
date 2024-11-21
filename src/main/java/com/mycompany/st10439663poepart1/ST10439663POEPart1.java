/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10439663poepart1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class ST10439663POEPart1 {
     static ArrayList<String> developers = new ArrayList<>();
    static ArrayList<String> taskNames = new ArrayList<>();
    static ArrayList<Integer> taskDurations = new ArrayList<>();
    static ArrayList<String> taskStatuses = new ArrayList<>();

    public static void main(String[] args) {
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
       String welcome;
       int option = 0; //
        int TotalHoursAmount = 0;

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
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban","Easy Kanban ",JOptionPane.INFORMATION_MESSAGE);

        while (option
                != 3) {
            option = Integer.parseInt(JOptionPane.showInputDialog(null,"Select an option to continue.:\n1: Add tasks\n2: Show report\n3: Quit","Easy Kanban - Options ",JOptionPane.INFORMATION_MESSAGE));

            switch (option) {
                case 1:
                    int capacity = Integer.parseInt(JOptionPane.showInputDialog(null,"How many tasks do you wish to capture?","Easy Kanban - Number of tasks ",JOptionPane.INFORMATION_MESSAGE));

                    // Arrays to hold task data for each task
                    String[] taskName = new String[capacity];
                    String[] taskDescription = new String[capacity];
                    String[] developerDetails = new String[capacity];
                    String[] taskID = new String[capacity];
                    int[] taskDuration = new int[capacity];
                    String[] taskStatus = new String[capacity];
                    Task task = new Task(capacity);  // Create a Task object to manage arrays

                    for (int i = 0; i < capacity; i++) {
                        // Prompt for task name and assign to array
                        taskName[i] = JOptionPane.showInputDialog(null,"Enter Task name for task " + (i + 1) + ":","Easy Kanban - Task Name ",JOptionPane.INFORMATION_MESSAGE);

                        // Task description input with validation (less than 50 characters)
                        do {
                            taskDescription[i] = JOptionPane.showInputDialog(null,"Enter Task Description for task " + (i + 1) + " (max 50 characters):","Easy Kanban - Task Description ",JOptionPane.INFORMATION_MESSAGE);
                        } while (!task.checkDescription(taskDescription[i]));  // Check length validation

                        // Developer details input and assign to array
                        developerDetails[i] = JOptionPane.showInputDialog(null,"Enter Developer Details (First and Last name) for task " + (i + 1) + ":","Easy Kanban - Task Developer details ",JOptionPane.INFORMATION_MESSAGE);

                        // Task duration input and assign to array
                        taskDuration[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Task Duration (in hours) for task " + (i + 1) + ":","Easy Kanban - Task Duration ",JOptionPane.INFORMATION_MESSAGE));

                        // Create and assign Task ID for each task in array
                        taskID[i] = task.CreateTaskID(taskName[i], i, developerDetails[i]);
                        

                        // Prompt for task status (To Do, Doing, Done) and assign to array
                        int statusOption = Integer.parseInt(JOptionPane.showInputDialog(null,"Choose a status for task " + (i + 1) + ":\n1: To Do\n2: Doing\n3: Done","Easy Kanban - Task Status ",JOptionPane.INFORMATION_MESSAGE));
                        switch (statusOption) {
                            case 1:
                                taskStatus[i] = "To Do";
                                break;
                            case 2:
                                taskStatus[i] = "Doing";
                                break;
                            case 3:
                                taskStatus[i] = "Done";
                                break;
                        }

                        // Print task details for each task
                        task.printTaskDetails(taskStatus[i], developerDetails[i], i, taskName[i], taskDescription[i], taskID[i], taskDuration[i]);

                        // Accumulate total hours for all tasks
                        TotalHoursAmount += task.returnTotalHours(taskDuration[i]);
                    }

                    // Display total hours of all tasks performed
                    JOptionPane.showMessageDialog(null, "The total hours of all the tasks performed: " + TotalHoursAmount + " hrs","Easy Kanban - Total Hours ",JOptionPane.PLAIN_MESSAGE);
                    break;



                case 2:
                    // Placeholder for future report feature
                    JOptionPane.showMessageDialog(null, "Report Coming Soon","Easy Kanban - Options ",JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    // Exit the program
                    JOptionPane.showMessageDialog(null, "GOODBYE!!!","Easy Kanban - Options ",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;

                default:
                    // Handle invalid options
                    JOptionPane.showMessageDialog(null, "Invalid option, please choose the correct option.","Easy Kanban - Options",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        
         populateData();
        String menu = """
                Choose an option:
                1. Display Done Tasks
                2. Display Longest Task
                3. Search Task by Name
                4. Search Tasks by Developer
                5. Delete Task by Name
                6. Exit
                """;

        while (true) {
            String choice = JOptionPane.showInputDialog(menu);
            if (choice == null || choice.equals("6")) break;

            switch (choice) {
                case "1" -> displayDoneTasks();
                case "2" -> displayLongestTask();
                case "3" -> {
                    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                    searchTaskByName(taskName);
                }
                case "4" -> {
                    String developer = JOptionPane.showInputDialog("Enter Developer Name:");
                    searchTasksByDeveloper(developer);
                }
                case "5" -> {
                    String taskName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                    deleteTaskByName(taskName);
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid Option!");
            }
        }
    }
    }

    public static void populateData() {
        developers.add("Mike Smith");
        developers.add("Edward Harrison");
        developers.add("Samantha Paulson");
        developers.add("Glenda Oberholzer");

        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        taskDurations.add(5);
        taskDurations.add(8);
        taskDurations.add(2);
        taskDurations.add(11);

        taskStatuses.add("To Do");
        taskStatuses.add("Doing");
        taskStatuses.add("Done");
        taskStatuses.add("To Do");
    }

    public static void displayDoneTasks() {
        StringBuilder output = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                output.append("Developer: ").append(developers.get(i))
                        .append(", Task Name: ").append(taskNames.get(i))
                        .append(", Duration: ").append(taskDurations.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void displayLongestTask() {
        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }
        String output = "Task with the longest duration:\nDeveloper: " + developers.get(maxIndex) +
                ", Task Name: " + taskNames.get(maxIndex) +
                ", Duration: " + taskDurations.get(maxIndex);
        JOptionPane.showMessageDialog(null, output);
    }

    public static void searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                String output = "Task Found:\nDeveloper: " + developers.get(i) +
                        ", Task Name: " + taskNames.get(i) +
                        ", Status: " + taskStatuses.get(i);
                JOptionPane.showMessageDialog(null, output);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found!");
    }

    public static void searchTasksByDeveloper(String developerName) {
        StringBuilder output = new StringBuilder("Tasks assigned to developer: ").append(developerName).append("\n");
        boolean found = false;
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerName)) {
                found = true;
                output.append("Task Name: ").append(taskNames.get(i))
                        .append(", Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, output.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for the developer: " + developerName);
        }
    }

    public static void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' successfully deleted!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found!");
        }
    }
    


   



