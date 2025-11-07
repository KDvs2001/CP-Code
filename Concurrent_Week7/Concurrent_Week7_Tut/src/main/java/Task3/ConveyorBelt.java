package Task3;

import java.util.concurrent.Semaphore;

public class ConveyorBelt {
    private final int[] buffer;
    private final int capacity;

    private int in = 0;
    private int out = 0;
    private int count = 0;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore empty;
    private final Semaphore full;
    public ConveyorBelt(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.empty = new Semaphore(capacity,true);
        this.full = new Semaphore(0,true);
    }

    public void produce(String machineName, int itemId) {
        try{
            empty.acquire();
            mutex.acquire();
            buffer[in] = itemId;
            in = (in+1) %capacity;
            count++;
            System.out.println(machineName + " machine stored an item " + itemId + " and the total count is "+ this.count);


        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
            full.release();
        }
    }

    public void consume(String packerName)  {
        int item = -1;
        try{
            full.acquire();
            mutex.acquire();
            while(count >0){
                item = buffer[out];
                out = (out+1) % capacity;
                count--;
                System.out.println(packerName + " consumsed " + item + " and total count is: "+ count);
            }

        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
            empty.release();
        }

    }

}
