package com.keyin;

public class User {
    private String name;
    private TaskList taskList;
    private static User[] users = new User[10];
    private static int currentUserIndex = 0;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();

        if (currentUserIndex < users.length) {
            users[currentUserIndex] = this;
            currentUserIndex++;
        } else {
            System.out.println("User array is full. Cannot add more users.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    // Add a task to the user's task list
    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void completeTask(int index) {
        taskList.markTaskAsCompleted(index);
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }

    public static boolean isDuplicate(String name) {
        for (int i = 0; i < currentUserIndex; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static User getUserByName(String name) {
        for (int i = 0; i < currentUserIndex; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }

    public static void printAllUsers() {
        System.out.println("List of all users:");
        for (int i = 0; i < currentUserIndex; i++) {
            System.out.println(users[i].getName());
        }
    }
}
