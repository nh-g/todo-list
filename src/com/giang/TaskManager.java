package com.giang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

/**
 * @author Giang
 * version 1.0
 * since 2021-03-19
 */

/**
 * This class represents ToDoList which contains the ArrayList of Task objects
 */

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(List<Task> tasks) {
        TaskManager.tasks = tasks;
    }

    /**
     * A method creates Task' ID incremented by 1
     */
    public static void setNextId() {
        int maxId = 0;
        for (Task task : getTasks()) {
            if ( task.getId() > maxId) {
                maxId = task.getId();
            }
        }
        Task.nextID = maxId + 1;
    }

    /**
     * A method displays the contents of sorted ArrayList sorted
     * in ascending order of project, or due date depending on user's choice
     * "1" for calling on a showTaskByProject method,
     * "2" for calling on a public static void showTaskByDeadline() { method.
     */
    public static void showTaskList() {
        boolean quit = false;
        while (!quit) {
            Menu.displayTaskMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    showTaskByProject();
                    break;
                case 2:
                    showTaskByDeadline();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println(">>>>>>>>>>Invalid entry. Please try again<<<<<<<<<<<<");
            }
        }
    }

    public static void showTaskByProject() {
        getTasks().sort(Comparator.comparing(Task::getProject).thenComparing(Task::getDueDate));
        for (Task task : getTasks()) {
            System.out.println(task);
        }
    }

    public static void showTaskByDeadline() {
        getTasks().sort(Comparator.comparing(Task::getDueDate).thenComparing(Task::getProject));
        for (Task task : getTasks()) {
            System.out.println(task);
        }
    }

    /**
     * A method calls on setter method of Task,
     * After task is created it's added to the list.
     */
    public static void addNewTask() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter Task Title");
        String taskName = sc.nextLine();
        if (taskName.trim().equalsIgnoreCase(""))
            throw new NullPointerException(">>>>>>>Title can not be *empty*<<<<<<");

        System.out.println("Please enter Project Name");
        String projectName = sc.nextLine();

        System.out.println("Please enter your Due date in the format yyyy-MM-dd HH:mm");
        Date d = parseDate(sc.nextLine());
        if (d == null) {
            return;
        }

        Task t = new Task();
        t.setId(++Task.nextID);
        t.setTitle(taskName);
        t.setDueDate(d);
        t.setProject(projectName);
        t.setStatus(Task.Status.NOT_STARED);
        getTasks().add(t);
        System.out.println("Task added successfully.");
        System.out.println("=========================");
    }

    private static Date parseDate(String inputDate) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(inputDate);
            if (date.compareTo(new Date()) < 0) {
                throw new DateTimeException(">>>>>>>>>Please enter date after today<<<<<<<<<");
            }
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please follow yyyy-MM-dd HH:mm");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A method to read the value from user
     * and after loops through the list trying to find a match by title
     *
     * @return task when title is matching with user's input
     */
    public static Task findTaskByTitle() {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        for (Task task : getTasks()) {
            if (task.getTitle().equalsIgnoreCase(userInput))
                return task;
            System.out.println(task);
        }
        System.err.println("You don't have a task with given title. Please enter a valid title");
        return null;
    }

    /**
     * A method to read the value from user
     * and after loops through the list trying to find a match by ID
     *
     * @return task when ID is matching with user's input
     */
    public static Task findTaskById() {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        for (Task task : getTasks()) {
            if (("" + task.getId()).equalsIgnoreCase(userInput))
                return task;
            System.out.println(task);
        }
        System.err.println(">>>>>>>>>>Invalid entry. Please enter a valid ID<<<<<<<<<<<<");
        return null;
    }
    /**
     * A method to read the value from user*
     * @return task when title is matching with user's input
     * "1" for calling on a findTaskByTitle method,
     * "2" for calling on a public static void findTaskById() method.
     */
    private static Task findTask() {

        boolean quit = false;


        while (!quit) {
            Menu.findTaskMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    return findTaskByTitle();
                case 2:
                    return findTaskById();
                case 3:
//                    Menu.mainMenu(completedTasksCount(), notCompletedTasksCount());
                    quit = true;
                    break;
                default:
                    System.out.println(">>>>>>>>>>Invalid entry. Please try again<<<<<<<<<<<<");
            }
        }
        return null;
    }

    /**
     * A method that sets new values to task's fields of: title, project, status
     *
     */
    public static void editTask() {
        boolean quit = false;

        Task task = findTask();

        while (!quit) {
            Scanner input = new Scanner(System.in);
            Menu.editTaskMenu();
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter new Title:");
                    Scanner sc = new Scanner(System.in);
                    task.setTitle(sc.nextLine());
                    System.out.println("\nTask's name is successfully changed");
                }
                case 2 -> {
                    System.out.println("Please enter new Project:");
                    Scanner sc = new Scanner(System.in);
                    task.setProject(sc.nextLine());
                    System.out.println("\nTask's project is successfully changed");
                }
                case 3 -> {
                    System.out.println("Status can only be: NOT_STARED, IN_PROGRESS, DONE.\nPlease enter status:");
                    Scanner sc = new Scanner(System.in);
                    task.setStatus(Task.Status.valueOf(sc.nextLine()));
                    System.out.println("\nTask's project is successfully changed");
                }
                case 4 -> {
                    System.out.println("Please enter new Deadline:");
                    Date d = null;
                    try {
                        d = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(input.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please follow yyyy-MM-dd HH:mm");
                        e.printStackTrace();
                    }
                    task.setDueDate(d);
                    System.out.println("\nTask's DeadLine is successfully changed");
                }
                case 5 -> {
                    quit = true;
                    break;
                }
            }
        }
        System.out.println("\nReturning to Main Menu!");
    }

    /**
     * A method calls on findTask method
     * and stores the value in a Task object
     *
     * removes the object from the List
     */
    public static void removeTask() {
        Task task = findTask();
        getTasks().remove(task);
        System.out.println("Task successfully deleted.");
        System.out.println("=========================");
    }

    public static void markTaskAsDone() {
        Task task = findTask();
        task.markCompleted();
        System.out.println("Congrats! You have completed a task");
        System.out.println("=========================");
    }

    public static int completedTasksCount() {
        int count = 0;

        for (Task task : getTasks()) {
            if (task.getStatus() == Task.Status.DONE) {
                count++;
            }
        }
        return count;
    }

    public static int notCompletedTasksCount() {
        int count = 0;

        for (Task task : getTasks()) {
            if (task.getStatus() != Task.Status.DONE) {
                count++;
            }
        }
        return count;
    }
}
