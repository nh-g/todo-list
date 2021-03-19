package com.giang;
/**
 * @author Giang
 * version 1.0
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();

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
        tasks.sort(Comparator.comparing(Task::getProject).thenComparing(Task::getDueDate));
        for (Task task : tasks) {
            task.display();
        }
    }

    public static void showTaskByDeadline() {
        tasks.sort(Comparator.comparing(Task::getDueDate).thenComparing(Task::getProject));
        for (Task task : tasks) {
            task.display();
        }
    }

    public static void addNewTask() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter Task Title");
        String taskName = sc.nextLine();
        if (taskName.trim().equalsIgnoreCase(""))
            throw new NullPointerException("Title can not be *empty*");

        System.out.println("Please enter Project Name");
        String projectName = sc.nextLine();

        System.out.println("Please enter Deadline");
        System.out.println("Please enter your date in the format yyyy-MM-dd hh:mm");
        Scanner scanner = new Scanner(System.in);
        Date d = parseDate(scanner.nextLine());
        if (d == null) {
            return;
        }

        Task t = new Task();
        t.setId(++Task.nextID);
        t.setTitle(taskName);
        t.setDueDate(d);
        t.setProject(projectName);
        t.setStatus(Task.Status.NOT_STARED);
        tasks.add(t);
        System.out.println("Task added successfully.");

    }

    private static Date parseDate(String inputDate) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(inputDate);
            if (date.compareTo(new Date()) < 0) {
                throw new DateTimeException(">>>>>>>>>Please enter date after today<<<<<<<<<");
            }
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please follow yyyy-MM-dd hh:mm");
            e.printStackTrace();
        }
        return null;
    }

    public static Task findTaskByTitle() {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(userInput))
                return task;
            System.out.println(task);
        }
        System.err.println("You don't have a task with given title. Please enter a valid title");
        return null;
    }

    public static Task findTaskById() {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        for (Task task : tasks) {
            if (("" + task.getId()).equalsIgnoreCase(userInput))
                return task;
            System.out.println(task);
        }
        System.err.println(">>>>>>>>>>Invalid entry. Please enter a valid ID<<<<<<<<<<<<");
        return null;
    }

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
                        System.out.println("Invalid date format. Please follow yyyy-MM-dd hh:mm");
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

    public static void removeTask() {
        Task task = findTask();
        tasks.remove(task);
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

        for (Task task : tasks) {
            if (task.getStatus() == Task.Status.DONE) {
                count++;
            }
        }
        return count;
    }

    public static int notCompletedTasksCount() {
        int count = 0;

        for (Task task : tasks) {
            if (task.getStatus() != Task.Status.DONE) {
                count++;
            }
        }
        return count;
    }
}
