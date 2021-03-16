package com.giang;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        boolean quit = false;
        String mainMenu = "" +
                "Welcome to ToDoLy\n" +
                "You have X tasks todo and Y tasks are done\n" +
                "Please pick an option:\n" +
                "1. Show todo list by Project\n" +
                "2. Show todo list by Deadline\n" +
                "3. Add a new Task\n" +
                "4. Edit Task\n" +
                "5. Remove Task \n" +
                "6. Mark as done\n" +
                "7. Quit\n\n";
        while (!quit) {

            //The Scanner will input the user's choice
            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    showTaskByProject();
                    break;
                case 2:
                    showTaskByDeadline();
                    break;
                case 3:
                    addNewTask();
                    break;
                case 4:
                    editTask();
                    break;
                case 7:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry. Please try again");

            }
        }
    System.exit(0);
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
        Task t = new Task();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter Task Title");
        String taskName = sc.nextLine();
        if(taskName.trim().equalsIgnoreCase(""))
            throw new NullPointerException("Title can not be *empty*");

        System.out.println("Please enter Project Name");
        String projectName = sc.nextLine();

        System.out.println("Please enter Deadline");
        System.out.println("Please enter your date in the format yyyy-MM-dd hh:mm");
        Scanner scanner = new Scanner(System.in);
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please follow yyyy-MM-dd hh:mm");
            e.printStackTrace();
        }

        t.setId(++Task.nextID);
        t.setTitle(taskName);
        t.setDueDate(d);
        t.setProject(projectName);
        t.setStatus(Task.Status.NOT_STARED);
        tasks.add(t);
        System.out.println("Task added successfully.");

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
        System.err.println("You don't have a task with given ID. Please enter a valid ID");
        return null;
    }
    private static Task findTaskToEdit() {

        boolean quit = false;

        String editTaskMenu = "" +
                "So now you want to edit a Task\n" +
                "Please pick an option:\n" +
                "1. Find the Task by Title\n" +
                "2. Find the Task by Task ID\n" +
                "3. Return to Main Menu\n\n";

        while (!quit) {

            //The Scanner will input the user's choice
            Scanner input = new Scanner(System.in);
            System.out.println(editTaskMenu);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    return findTaskByTitle();

                case 2:
                    return findTaskById();

                case 3:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry try again");
            }

        }
        return null;
    }

    public static void editTask() {
        boolean quit = false;

        Task task = findTaskToEdit();
        System.out.println(task);
        String editTaskMenu = "" +
                "Please pick an option:\n" +
                "1. Change Task's Title\n" +
                "2. Change Task's Project\n" +
                "3. Change Task's Status\n" +
                "4. Change Task's Deadline\n" +
                "5. Return to Main Menu\n\n";

        while (!quit)  {
            Scanner input = new Scanner(System.in);
            System.out.println(editTaskMenu);
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
}

