package org.example;

public class Plate {
    private String food; // This is the shared variable
    private boolean available = false;

    public synchronized void putFood(String food) { // Producer calls this method.
        while (available) {
            try {
                wait(); // RUNNABLE --> INFINITE WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.food = food;
        this.available = true;
        notifyAll();

    }


    public synchronized String getFood() {
        while (!available) {
            try {
                wait(); // RUNNABLE --> INFINITE WAITING
                // This is the place the thread will resume.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.available = false;
        notifyAll();
        return this.food;

    }
}


