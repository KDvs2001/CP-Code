package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Plate {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
    public  void putFood(String food) { // Producer calls this method.
        try {
            queue.put(food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public  String getFood() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}