package org.example;

import java.util.Random;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int mailboxCapacity = 5;
        final int producerCount = 5;
        final int consumerCount = 2;
        final int itemsPerProducer = 10;
        final int itemsPerConsumer = 100; // large so consumers normally wait until shutdown

        MultiSlotMailbox<Integer> mailbox = new MultiSlotMailbox<>(mailboxCapacity);
        Random random = new Random();

        // Safe generator (ensures bound >= 1)
        IntFunction<Integer> safeRandomGenerator = bound -> random.nextInt(Math.max(1, bound));

        Thread[] producers = new Thread[producerCount];
        Thread[] consumers = new Thread[consumerCount];

        for (int i = 0; i < producerCount; i++) {
            Producer<Integer> p = new Producer<>(mailbox, safeRandomGenerator::apply, itemsPerProducer);
            producers[i] = new Thread(p, "Producer-" + i);
            producers[i].start();
        }

        for (int i = 0; i < consumerCount; i++) {
            Consumer<Integer> c = new Consumer<>(mailbox, itemsPerConsumer);
            consumers[i] = new Thread(c, "Consumer-" + i);
            consumers[i].start();
        }

        // Wait for all threads to finish. As soon as one finishes it will call mailbox.shutdown()
        for (Thread t : producers) t.join();
        for (Thread t : consumers) t.join();

        System.out.println("Main: all threads terminated. Exiting.");
    }
}
