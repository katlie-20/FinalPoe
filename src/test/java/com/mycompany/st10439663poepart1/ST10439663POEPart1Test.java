/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10439663poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class ST10439663POEPart1Test {
    @Test
    public void testPopulateData() {
        // Setup
        ST10439663POEPart1.populateData();
        
        

        // Assertions for developers
        assertEquals("Mike Smith", ST10439663POEPart1.developers.get(0));
        assertEquals("Edward Harrison", ST10439663POEPart1.developers.get(1));
        assertEquals(4, ST10439663POEPart1.developers.size());

        // Assertions for task names
        assertEquals("Create Login", ST10439663POEPart1.taskNames.get(0));
        assertEquals(4, ST10439663POEPart1.taskNames.size());

        // Assertions for task durations
        assertEquals(5, ST10439663POEPart1.taskDurations.get(0));
        assertEquals(11, ST10439663POEPart1.taskDurations.get(3));
    }

    @Test
    public void testDisplayDoneTasks() {
        // Setup
        ST10439663POEPart1.populateData();

        // Capture output using a custom PrintStream
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            public synchronized void write(int b) {
                output.append((char) b);
            }
        }));

        // Execute
        ST10439663POEPart1.displayDoneTasks();

        // Assertions
        String expected = "Tasks with status 'Done':\nDeveloper: Samantha Paulson, Task Name: Create Reports, Duration: 2\n";
        assertTrue(output.toString().contains(expected.trim()));
    }

    @Test
    public void testDisplayLongestTask() {
        // Setup
        ST10439663POEPart1.populateData();

        // Capture output
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            public synchronized void write(int b) {
                output.append((char) b);
            }
        }));

        // Execute
        ST10439663POEPart1.displayLongestTask();

        // Assertions
        String expected = "Task with the longest duration:\nDeveloper: Glenda Oberholzer, Task Name: Add Arrays, Duration: 11\n";
        assertTrue(output.toString().contains(expected.trim()));
    }

    @Test
    public void testSearchTaskByName() {
        // Setup
        ST10439663POEPart1.populateData();

        // Capture output
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            public synchronized void write(int b) {
                output.append((char) b);
            }
        }));

        // Execute
        ST10439663POEPart1.searchTaskByName("Create Login");

        // Assertions
        String expected = "Task Found:\nDeveloper: Mike Smith, Task Name: Create Login, Status: To Do\n";
        assertTrue(output.toString().contains(expected.trim()));
    }

    @Test
    public void testDeleteTaskByName() {
        // Setup
        ST10439663POEPart1.populateData();

        // Execute
        ST10439663POEPart1.deleteTaskByName("Create Reports");

        // Assertions
        assertFalse(ST10439663POEPart1.taskNames.contains("Create Reports"));
        assertEquals(3, ST10439663POEPart1.taskNames.size());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        // Setup
        ST10439663POEPart1.populateData();

        // Capture output
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            public synchronized void write(int b) {
                output.append((char) b);
            }
        }));

        // Execute
        ST10439663POEPart1.searchTasksByDeveloper("Samantha Paulson");

        // Assertions
        String expected = "Tasks assigned to developer: Samantha Paulson\nTask Name: Create Reports, Status: Done\n";
        assertTrue(output.toString().contains(expected.trim()));
    }
    
    
}
