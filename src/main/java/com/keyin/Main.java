package com.keyin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();  // Fixed: User, not Users
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the To-Do List Tracker");
            System.out.println("1: Add a User");
            System.out.println("2: Add a Task for a User");
            System.out.println("3: Mark Task as Complete for a User");
            System.out.println("4: View Tasks for a User");
            System.out.println("5: View all Users");
            System.out.println("6: Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name for the new user:");
                    String name = scanner.nextLine();

                    if (isDuplicate(users, name)) {
                        System.out.println("Username already exists. Try another one.");
                    } else {
                        users.add(new User(name));
                        System.out.println("User '" + name + "' added successfully!");
                    }
                    break;

                case 5:
                    System.out.println("");

                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean isDuplicate(ArrayList<User> users, String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
