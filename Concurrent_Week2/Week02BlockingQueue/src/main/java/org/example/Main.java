package org.example;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Thread child = new Thread(new Child(plate) , "Child"); // State of the Thread = NEW
        Thread mother = new Thread(new Mother(plate) , "Mother"); // State of the Thread = NEW
        child.start(); // Thread Enters WAIT --> RUNNABLE
        mother.start(); // Thread Enters WAIT --> RUNNABLE
    }
}