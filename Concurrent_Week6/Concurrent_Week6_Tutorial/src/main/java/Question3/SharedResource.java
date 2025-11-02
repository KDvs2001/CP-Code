package Question3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int counter =0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    public void waitForCondition(int targetValue){
        try{
            lock.lock();
            while(counter != targetValue){
                try{
                    condition.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public int incrementCounter(){
        try{
            lock.lock();
            counter++;
            condition.signalAll();
            return counter;
        }finally {
            lock.unlock();
        }
    }


}
