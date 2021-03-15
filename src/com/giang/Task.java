package com.giang;
import java.util.Date;

public class Task {
//    a task title, due date, status and project
    private String title;
    private Date dueDate;
    private String status;
    private String project;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void display() {
        System.out.println("Title: " + "; " + this.title + "Deadline: " + this.dueDate + "; " + "Status: "+ this.status + "; " + "Project "+ this.project);
    }

}
