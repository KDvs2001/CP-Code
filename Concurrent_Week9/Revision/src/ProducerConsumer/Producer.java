package ProducerConsumer;

public class Producer implements Runnable {
    private Monitor monitor;
    public Producer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try{
                monitor.put(i);
                System.out.println(Thread.currentThread().getName() + " added " + i + " to the slot");
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}
