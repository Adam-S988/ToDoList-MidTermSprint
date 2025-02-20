package com.keyin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> user = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter the name for the new user (or type 'exit' to stop)");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            } else {
                user.add(new User(name));
                System.out.println("User '" + name + "' added successfully!");
            }
        }
        scanner.close();
    }

    private static boolean isDuplicate(ArrayList<User> users, String name) {
        for (User user: users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}