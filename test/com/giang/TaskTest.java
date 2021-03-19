package com.giang;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    static Task task;

    @BeforeAll
    static void setUp() {
        task = new Task();
        task.setId(++Task.nextID);
        task.setTitle("taskName");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;
        try {
            date = formatter.parse("2050-10-10 10:10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setDueDate(date);
        task.setProject("projectName");
        task.setStatus(Task.Status.NOT_STARED);
    }

    @Test
    void tasksAddedToList() {
        assertEquals(task.getId(), Task.nextID);
    }

}