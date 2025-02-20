package com.keyin;

public class User {
    private String name;
    private TaskList taskList;

    public User (String name) {
        this.name = name;
        this.taskList = new TaskList();
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
}
