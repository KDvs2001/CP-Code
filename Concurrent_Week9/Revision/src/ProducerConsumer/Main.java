package ProducerConsumer;

public class Main {
    static void main() {
        Monitor monitor = new Monitor();
        Producer producer = new Producer(monitor);
        Consumer consumer = new Consumer(monitor);

        Thread producerThread = new Thread(producer , "Producer Thread");
        Thread consumerThread = new Thread(consumer , "Consumer Thread");
        producerThread.start();
        consumerThread.start();

    }
}
