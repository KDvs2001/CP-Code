package ProducerConsumer;
import java.util.concurrent.Semaphore;
public class Monitor {
    private Integer slot;

    public synchronized void put(int value) throws InterruptedException {
        while(slot != null){
            wait();
        }
        slot = value;
        notifyAll();
    }
    public synchronized Integer get() throws InterruptedException {
        while(slot == null){
            wait();
        }
        int value = slot;
        slot = null;
        notifyAll();
        return value;

    }
}