package ProducerConsumer;

public class Consumer implements Runnable {
    private Monitor monitor;
    public Consumer(Monitor monitor) {
        this.monitor = monitor;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                int value = monitor.get();
                System.out.println(Thread.currentThread().getName() + " returned " + value + " from the slot");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
