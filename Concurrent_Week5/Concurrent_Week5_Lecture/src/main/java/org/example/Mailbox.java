package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Mailbox {
    private List<Integer> item = new ArrayList<Integer>(); // This is the shared variable.
    private int capacity;
    private Semaphore emptySlots;
    private Semaphore fullSlots;
    private Semaphore mutex;

    public Mailbox(int capacity){
        this.capacity = capacity;
        // Counting semaphore : - emptySlots and fullSlots. This is to keep track of count of emptySlots and fullSlots.
        this.emptySlots = new Semaphore(capacity, true); // Initially all the slots are empty.Therefore, the number of permit is equals to the capacity.
        this.fullSlots = new Semaphore(0, true); // Initially there are 0 available slots. Therefore, the number of permit is equals to 0
        this.mutex = new Semaphore( 1); // This is for locking the critical section (Binary semaphore).

    }
    public  void put(int value){
        try{
            emptySlots.acquire();  // A permit is acquired on empty slot
            mutex.acquire(); // lock
            item.add(value); // An item is added.
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release(); // unlock
            fullSlots.release(); // Increase the permit by +1 in the fullSlot because an item has been produced.
        }
    }

    public  int get(){
        int value = -1;
        try{
            fullSlots.acquire(); // Since an item is going to be removed by the consumer , consumer will be acquiring a permit.
            mutex.acquire();
            value = item.remove(0);

        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
            emptySlots.release();
        }
        return value;

    }
}
