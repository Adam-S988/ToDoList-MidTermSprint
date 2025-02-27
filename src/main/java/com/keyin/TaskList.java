package com.keyin;

public class TaskList {
    private static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void addTask(String description) {
        Task newTask = new Task(description, false);
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void markTaskAsCompleted(int index) {
        if (head == null) {
            System.out.println("No tasks available to mark as completed.");
            return;
        }

        if (index < 0) {
            System.out.println("Invalid task index. Please enter a non-negative number.");
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.task.setCompleted(true);
                System.out.println("Task marked as completed!");
                return;
            }
            current = current.next;
            count++;
        }

        System.out.println("Invalid task index. No task found at position " + index + ".");
    }


    @Override
    public String toString() {
        if (head == null) {
            return "No tasks available.";
        }

        StringBuilder taskDetails = new StringBuilder();
        Node current = head;
        int id = 0;

        while (current != null) {
            String status = current.task.isCompleted() ? "\u001B[32mCompleted\u001B[0m" : "\u001B[31mPending\u001B[0m";
            taskDetails.append("     Description: ").append(current.task.getDescription())
                    .append("\n     ID: ").append(id)
                    .append("\n     Status: ").append(status)
                    .append("\n");
            current = current.next;
            id++;
        }

        return taskDetails.toString();
    }

}
