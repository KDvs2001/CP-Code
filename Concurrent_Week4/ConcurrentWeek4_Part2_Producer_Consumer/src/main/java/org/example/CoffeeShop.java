package org.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoffeeShop {
    private final Queue<String> orders = new ArrayDeque<String>();
    private int capacity;
    private boolean closed = false;
    private final Lock lock = new ReentrantLock(true);
    private final Condition notFull = lock.newCondition(); // this condition is for consumer thread to await()
    private final Condition notEmpty = lock.newCondition(); // this condition is for producer thread to await()

    public CoffeeShop(int capacity) {
        this.capacity = capacity;
    }

    public void done(){
        try{
            lock.lock();
            closed = true;
            notEmpty.signalAll();
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void placeOrder(String order){
        try{
            lock.lock();
            while(orders.size() == capacity){
                try{
                    notEmpty.await(); // Producer goes into WAITING state on notEmpty condition.
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            orders.offer(order);
            notFull.signalAll(); // Producer informs the Consumer in the WAITING state to come out of WAITING --> RUNNABLE

        }finally {
            lock.unlock();
        }
    }

    public String processOrder(){
        try{
            lock.lock();
            while(orders.isEmpty()){
                if(closed){
                    return null;  // If closed = true means all the consumers are done. Inform baristas to stop processing.
                }
                try{
                    notFull.await(); // Baristas put into WAITING state because nothing to process.
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(closed){
                return null;
            }
            String order = orders.poll();
            notEmpty.signalAll();
            return order;
        }finally {
            lock.unlock();
        }
    }
}
