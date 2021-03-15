package com.giang;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        boolean quit = false;
        String mainMenu = "" +
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

                case 7:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry try again");

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

    public void createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name");
        String taskName = sc.nextLine();
        System.out.println("Please enter employee name");
        String projectName = sc.nextLine();
        System.out.println("Please enter due date");
        System.out.println("Please enter your date in the format dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        Date d = null;
        try {
            d = new DateTimeFormatter("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Task t = new Task();
        t.setTitle(taskName);
        t.setDueDate(d);
        t.setProject(projectName);
        tasks.add(t);
        System.out.println("Task added successfully.");

    }

}
