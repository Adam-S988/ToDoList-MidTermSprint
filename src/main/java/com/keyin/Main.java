package com.keyin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the To-Do List Tracker");
            System.out.println("1: Add a User");
            System.out.println("2: Add a Task for a User");
            System.out.println("3: Mark Task as complete for a User");
            System.out.println("4: View Tasks for a user");
            System.out.println("5: View All Users");
            System.out.println("6: Exit");

            int choice = getValidInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("\nEnter the name for the new user:");
                    String name = scanner.nextLine();

                    if (User.isDuplicate(name)) {
                        System.out.println("\nUsername already exists. Try another one.");
                    } else {
                        new User(name);
                        System.out.println("\nUser '" + name + "' added successfully!");
                    }
                    break;

                case 2:
                    System.out.println("\nEnter the user's name to add a task:");
                    String userName = scanner.nextLine();
                    User user = User.getUserByName(userName);
                    if (user != null) {
                        System.out.println("\nEnter the task description:");
                        String taskDescription = scanner.nextLine();
                        user.addTask(taskDescription);
                    } else {
                        System.out.println("\nUser not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nEnter the user's name to mark a task as completed:");
                    String userForCompletion = scanner.nextLine();
                    User userForTaskCompletion = User.getUserByName(userForCompletion);
                    if (userForTaskCompletion != null) {
                        int taskIndex = getValidInt(scanner, "Enter the task index to mark as complete: ");
                        userForTaskCompletion.completeTask(taskIndex);
                    } else {
                        System.out.println("\nUser not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nEnter the user's name to view tasks:");
                    String userForViewing = scanner.nextLine();
                    User userForView = User.getUserByName(userForViewing);
                    if (userForView != null) {
                        userForView.printTasks();
                    } else {
                        System.out.println("\nUser not found.");
                    }
                    break;

                case 5:
                    User.printAllUsers();
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }

    private static int getValidInt(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } else {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
