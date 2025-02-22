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
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
            }
        }
    }
}
