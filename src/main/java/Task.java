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

    // printing of the task details
    public String printTaskDetails() {
        return "Task Name: " + taskName + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Duration: " + taskDuration + "\n" +
               "Task Status: " + taskStatus + "\n" +
               "Task ID: " + taskID + "hrs\n";
    }

    // Return task duration
    public int returnTaskDuration() {
        return taskDuration;
    }

    Object getTaskStatus() {
        return taskStatus;
    }

    Object getTaskID() {
        return taskID;
    }

    short getTaskDuration() {
        short TaskDuration = 0;
        return TaskDuration;
    }

    Object getDeveloperDetails() {
        return developerDetails;
    }

    Object getTaskDescription() {
        return taskDescription;
    }
    Object getTaskName() {
        return taskName;
    }
}