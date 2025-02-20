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

    public void deleteTask(int index) {
        if (head == null) {
            System.out.println("The Task List is empty.");
            return;
        }

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node current = head;
        int count = 0;

        while (current.next != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
            return;
        }

        if (current.next.next == null) {
            tail = current;
        }

        current.next = current.next.next;
    }

    public void markTaskAsCompleted(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.task.setCompleted(true);
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Task not found.");
    }

    public void printTasks() {
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println(index + ". " + current.task);
            current = current.next;
            index++;
        }
    }
}
