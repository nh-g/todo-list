package com.giang;
/**
 * @author Giang
 * version 1.0
 */

import java.util.*;

public class Main {
    public static String filename = "todolist.obj";

    public static void main(String[] args) {
        TaskManager todolist = new TaskManager();

        boolean quit = false;
        while (!quit) {

            Scanner input = new Scanner(System.in);
            Menu.mainMenu(todolist.completedTasksCount(), todolist.notCompletedTasksCount());

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    todolist.showTaskList();
                    break;
                case 2:
                    todolist.addNewTask();
                    break;
                case 3:
                    todolist.editTask();
                    break;
                case 4:
                    todolist.markTaskAsDone();
                    break;
                case 5:
                    todolist.removeTask();
                    break;
                case 6:
                    quit = true;
                    break;

                default:
                    System.out.println(">>>>>>>>>>Invalid entry. Please try again<<<<<<<<<<<<");

            }
        }
    System.exit(0);
    }
}

