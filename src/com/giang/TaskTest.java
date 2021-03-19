//package com.giang;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.DateTimeException;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Test class for Task class.
// *
// * @author Giang
// * @version 1.0
// * @since 2021-03-15
// */
//
//public class TaskTest {
//    // Create a new Task object
//    private static final Task task = new Task();
//
//    /**
//     * Set up all the Task's field's
//     * In the end it will test that createTask method
//     * and all the setter methods are working correctly
//     */
//    @BeforeAll
//    public static void setTaskFields() {
//        String input = "1task1\nproject1\n2034-05-03";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//
//        task.display();
//    }
//
//    /**
//     * Assert that getName method returns a correct task's name.
//     */
//    @Test
//    public void taskHasACorrectName() {
//        assertEquals("task1", task.getTitle());
//    }
//
//    /**
//     * Assert that getProject method returns a correct task's project.
//     */
//    @Test
//    void taskHasACorrectProject() {
//        assertEquals("project1", task.getProject());
//    }
//
//    /**
//     * Assert that getDueDate method returns a correct task's due date.
//     */
//    @Test
//    void taskHasACorrectDueDate() {
//        assertEquals("2034-05-03", task.getDueDate().toString());
//    }
//
//    /**
//     * Assert that status field is false
//     * when task object is created.
//     */
//    @Test
//    void statusIsFalseWhenTaskIsCreated() {
//        assertFalse(task.getStatus());
//    }
//
//    /**
//     * Assert that status field is true
//     * when task is marked as done.
//     */
//    @Test
//    void statusIsTrueWhenTaskIsMarkedAsDone() {
//        task.markCompleted();
//        assertTrue(task.getStatus());
//    }
//
//    /**
//     * Assert that NullPointerException is thrown
//     * when we try to set a name as an empty string
//     */
//    @Test
//    public void exceptionIsThrownOnEmptyTitle() {
//        assertThrows(NullPointerException.class, () -> task.setTitle(""));
//    }
//
//    /**
//     * Assert that NullPointerException is thrown
//     * when we try to set a name with only empty spaces and no characters.
//     */
//    @Test
//    public void exceptionIsThrownOnTitleWithOnlySpaces() {
//        assertThrows(NullPointerException.class, () -> task.setTitle("   "));
//    }
//
//    /**
//     * Assert that DateTimeException is thrown
//     * when we try to set a due date in past
//     */
//    @Test
//    public void exceptionIsThrownOnDueDateSetInPast() {
//        assertThrows(DateTimeException.class, () -> task.setDueDate(LocalDate.parse("2021-03-14")));
//    }
//
//    /**
//     * Assert that DateTimeException is thrown
//     * when we try to set a due date with wrong format
//     */
//    @Test
//    public void exceptionIsThrownOnDueDateWithWrongFormat() {
//        assertThrows(DateTimeException.class, () -> task.setDueDate(LocalDate.parse("22-05-03")));
//    }
//}
//
//
//
