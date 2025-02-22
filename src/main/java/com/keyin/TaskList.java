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

//    public void printTasks() {
//        if (head == null) {
//            System.out.println("User has no tasks.");
//            return;
//        }
//
//        Node current = head;
//        int id = 0;
//
//        while (current != null) {
//            String status = current.task.isCompleted() ? "Completed" : "In Progress";
//            System.out.println("     Description: " + current.task.getDescription() +
//                    "\n     ID: " + id +
//                    "\n     Status: " + status);
//            current = current.next;
//            id++;
//        }
//    }

    @Override
    public String toString() {
        if (head == null) {
            return "User has no tasks.";
        }

        StringBuilder taskDetails = new StringBuilder();
        Node current = head;
        int id = 0;

        while (current != null) {
            String status = current.task.isCompleted() ? "Completed" : "In Progress";
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
