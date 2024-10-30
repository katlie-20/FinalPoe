/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class Task {
    public String taskName;
    public int taskNumber;
    public String taskDescription;
    public String developerDetails;
    public int taskDuration;
    public String taskID;
    public String taskStatus;
    
    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskNumber, String taskStatus, String doing) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    // Check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // creation and return of task ID
    public String createTaskID() {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String developerEnd = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + developerEnd;
    }

    // Method to return full task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    // Method to return task duration
    public int getTaskDuration() {
        return taskDuration;
    }
    
    // method to calculate total hours across multiple tasks
    public int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    Object getTaskName() {
        return taskName;
    }

    Object getTaskDescription() {
        return taskDescription;
    }

    Object getDeveloperDetails() {
        return developerDetails;
    }
    Object getTaskID() {
        return taskID;
    }

    Object getTaskStatus() {
        return taskStatus;
    }
    
    }

    