package Question2;

public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException{
        SharedBuffer buffer = new SharedBuffer(3);
        Thread producerThread = new Thread(new Producer(buffer),"Producer Thread");
        Thread consumerThread = new Thread(new Consumer(buffer),"Consumer Thread");
        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
        System.out.println("Successfully Executed");


    }
}
