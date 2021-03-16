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
                "Pick an option:\n" +
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

                case 7:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry try again");

            }
        }
        System.exit(0);
    }


    public static void showTaskByProject()   {
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

        Task t = new Task();
        t.setId(++Task.nextID);
        t.setTitle(taskName);
        t.setDueDate(d);
        t.setProject(projectName);
        tasks.add(t);
        System.out.println("Task added successfully.");
    }

    public static void editTask() {

    }

}
