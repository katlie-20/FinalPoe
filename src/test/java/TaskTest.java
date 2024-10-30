/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import javax.swing.JOptionPane;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
  
    public Task task1;
    public Task task2;
    
     TaskTest TaskTest = new TaskTest();
    
    
    public void setUp() {
        // Task 1 - Using the provided test data
        task1 = new Task("Login Feature", "Create Login to verify users", "Robyn Harrison", 8, "Auto generated", "To Do");

        // Task 2 - Using the provided test data
        task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Auto generated", "Doing");
    }
      @Test
    public void testTask1() {
        // Task 1 test assertions
        assertEquals("Login Feature", task1.getTaskName());
        assertEquals("Create Login to authenticate users", task1.getTaskDescription());
        assertEquals("Robyn Harrison", task1.getDeveloperDetails());
        assertEquals(8, task1.getTaskDuration());
        assertEquals("Auto generated", task1.getTaskID());
        assertEquals("To Do", task1.getTaskStatus());
    }
    @Test
    public void testTask2() {
        // Task 2 test assertions
        assertEquals("Add Task Feature", task2.getTaskName());
        assertEquals("Create Add Task feature to add task users", task2.getTaskDescription());
        assertEquals("Mike Smith", task2.getDeveloperDetails());
        assertEquals(10, task2.getTaskDuration());
        assertEquals("Auto generated", task2.getTaskID());
        assertEquals("Doing", task2.getTaskStatus());
    }
    public void testChecktaskDescription(){
        
    }
}
