package com.giang;

/**
 * @author Giang
 * version 1.0
 */


public class Menu {
    /**
     * This method displays the main menu
     * with all options for user navigation selection
     *
     * @param completedTasksCount    takes the number of completed tasks (int) to display.
     * @param notCompletedTasksCount takes the number of uncompleted tasks (int) to display.
     */
    public static void mainMenu(int completedTasksCount, int notCompletedTasksCount) {
        System.out.println("\n>> Welcome to ToDoLy");
        System.out.println(">> You have " + notCompletedTasksCount + " tasks to complete and " +  completedTasksCount + " tasks finished!");
        System.out.println("\n>> Please pick an option:");
        System.out.println(">>> 1) Show ToDo List");
        System.out.println(">>> 2) Add New Task");
        System.out.println(">>> 3) Edit Task");
        System.out.println(">>> 4) Mark Task as Done");
        System.out.println(">>> 5) Remove Task");
        System.out.println(">>> 6) Save and Quit");
        System.out.println(">> Please enter your choice (1-7):");
    }

    /**
     * This method displays the menu to
     * find task by Title or ID
     * according to user's selection
     */
    public static void findTaskMenu() {
        System.out.println("\n>> Please pick an option:");
        System.out.println(">>> 1) Find the Task by Title");
        System.out.println(">>> 2) Find the Task by Task's ID");
        System.out.println(">>> 3) Return to previous Menu");
        System.out.println(">>  Please enter your choice (1-3):");
    }

    /**
     * This method displays the menu to show the options
     * to edit task fields
     * according to user's selection
     */
    public static void editTaskMenu() {
        System.out.println("\n>> Edit Task Menu");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Edit Task's Name");
        System.out.println(">>> 2) Edit Task's Project");
        System.out.println(">>> 3) Edit Task's Status");
        System.out.println(">>> 4) Edit Task's Due Date");
        System.out.println(">>> 5) Return to Main Menu");
        System.out.println(">>  Please enter your choice (1-5):");
    }


    /**
     * This method displays the menu to show the options
     * to show task list by project or deadline in ascending order
     * according to user's selection
     */
    public static void displayTaskMenu() {
        System.out.println("\n>> Show Task Menu");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Show List by Project");
        System.out.println(">>> 2) Show List by Deadline");
        System.out.println(">>> 3) Return to Main Menu");
        System.out.println(">>  Please enter your choice (1-3):");
    }

}


