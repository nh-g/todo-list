package com.giang;


import java.io.Serializable;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Giang
 * version 1.0
 * since 2021-03-19
 */

public class Task implements Serializable {
    public static int nextID = 0;
    private int id;
    private String title;
    private Date dueDate;
    private Status status;
    private String project;

    public enum Status{
        NOT_STARED, IN_PROGRESS, DONE,
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public boolean markCompleted() {
        this.setStatus(Status.DONE);
        return true;
    }


//    public void display() {
//        System.out.println("Task ID: " + this.id + "; " + "Title: " + this.title + "; " + "Deadline: " + this.dueDate + "; " + "Status: "+ this.status + "; " + "Project "+ this.project);
//    }

    /**
     * A method to get the task data as formatted string to display in multiple lines
     * @return formatted string of all fields of a task
     */
    public String toString() {
        return "\n======\nID: " + id + "\nTITlE: " + title + "\nPROJECT: " + project + "\nDUE DATE: " + dueDate + "\nSTATUS: " + status + "\n====================";
    }
}

