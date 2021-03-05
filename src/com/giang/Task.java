package com.giang;

public class Task {
//    a task title, due date, status and project
    private String title;
    private String dueDate;
    private String status;
    private String project;


    public Task(String title, String dueDate, String status, String project) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
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
        System.out.println(this.title + this.dueDate + this.status + this.project);
    }

    static public Task createTask() {
        return new Task("1", "2021-03-01", "open", "KTH");
    }
}
