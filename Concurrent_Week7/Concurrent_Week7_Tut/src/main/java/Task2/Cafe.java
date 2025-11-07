package Task2;

import java.util.concurrent.Semaphore;

public class Cafe {
    private final Semaphore mutex = new Semaphore(1);
    private int currentStock = 0;

    public void make() {
        try{
            mutex.acquire();
            this.currentStock +=1;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
        }
    }

    public void sell() {
        try{
            mutex.acquire();
            while(currentStock > 0){
                this.currentStock -= 1;

            }


        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
        }
    }

    public int getCurrentStock() {
        return currentStock;
    }
}
