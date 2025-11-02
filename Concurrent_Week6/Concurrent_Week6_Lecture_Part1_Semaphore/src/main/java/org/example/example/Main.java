package org.example.example;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mailbox mailbox = new Mailbox(5);
        Thread [] consumerThread = new Thread[5];
        Thread [] producerThread = new Thread[5];

        for(int i =0; i<producerThread.length;i++){
            producerThread[i] = new Thread(new Producer(mailbox, 10, 10), "Producer " + i);
        }
        for(int i=0;i<consumerThread.length;i++){
            consumerThread[i] = new Thread(new Consumer(mailbox, 10, 10), "Consumer " + i);
        }

        for(Thread t: producerThread){
            t.start();
        }

        for(Thread t: consumerThread){
            t.start();
        }


        for(Thread t: producerThread){
            t.join();
        }

        for(Thread t: consumerThread){
            t.join(10);
        }

        System.out.println("==================================All Done!==================================");

    }
}
