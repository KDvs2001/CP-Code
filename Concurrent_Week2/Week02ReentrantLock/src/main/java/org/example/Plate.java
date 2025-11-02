package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Plate {
    private String food; // This is the shared variable
    private boolean available = false;
    private Lock lock = new ReentrantLock(true);
    private Condition notFood = lock.newCondition(); // notFood is the condition which producer is going to make
    private Condition haveFood = lock.newCondition(); // haveFood is the condition which consumer is going to make
    public  void putFood(String food) { // Producer calls this method.
        try
        {
            lock.lock();
            while (available) {
                try {
                    notFood.await(); // RUNNABLE --> INFINITE WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.food = food;
            this.available = true;
            haveFood.signalAll(); // Consumers will be awakened WAITING --> RUNNABLE
        }finally {
            lock.unlock();
        }
    }
    public  String getFood() {
        try{
            lock.lock();
            while (!available) {
                try {
                    haveFood.await(); // RUNNABLE --> INFINITE WAITING
                    // This is the place the thread will resume.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.available = false;
            notFood.signalAll();
            return this.food;
        }finally {
            lock.unlock();
        }
    }
}