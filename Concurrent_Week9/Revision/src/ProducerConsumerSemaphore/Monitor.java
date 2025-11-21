package ProducerConsumerSemaphore;
import java.util.concurrent.Semaphore;
public class Monitor {
    private Integer slot;
    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore full = new Semaphore(1, true);
    private Semaphore empty = new Semaphore(0, true);
    public void put(int value) throws InterruptedException {
        try {
            full.acquire();
            mutex.acquire();
            slot = value;
        }finally {
            mutex.release();
            empty.release();
        }
    }
    public  Integer get() throws InterruptedException {
        try{
            empty.acquire();
            mutex.acquire();
            int value = slot;
            slot = null;
            return value;
        }finally {
            mutex.release();
            full.release();
        }
    }
}