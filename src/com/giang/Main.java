package com.giang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean quit = false;
        String mainMenu = "" + "1. Show todo list\n" + "9. Quit\n\n";
        while (!quit) {

            //The Scanner will input the user's choice
            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            int choice = input.nextInt();

            //you can any conditional statement (if/else or switch)
            //each case, will run the function
            switch (choice) {
                case 1:
                    showTask();
                    break;
                //create a case for each menu option

                case 9:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid entry try again");

            }
        }
        System.exit(0);
    }

    static private void showTask() {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(Task.createTask());
        tasks.add(Task.createTask());
        tasks.add(Task.createTask());
        tasks.add(Task.createTask());
        for (Task task : tasks) {
            task.display();
        }
    }

}
