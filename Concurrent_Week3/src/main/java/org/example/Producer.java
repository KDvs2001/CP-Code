package org.example;

import java.util.function.IntFunction;

public class Producer<E> implements Runnable {
    private final Mailbox<E> mailbox;
    private final IntFunction<E> generator;
    private final int itemsToProduce;

    public Producer(Mailbox<E> mailbox, IntFunction<E> generator, int itemsToProduce) {
        this.mailbox = mailbox;
        this.generator = generator;
        this.itemsToProduce = itemsToProduce;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemsToProduce; i++) {
                // exit early if mailbox is already shutdown
                if (mailbox.isShutdown()) break;
                E item = generator.apply(i);
                mailbox.put(item); // may throw InterruptedException if shutdown
                System.out.println(Thread.currentThread().getName() + " produces " + item);
            }
            // normal completion: request shutdown so everyone stops
            mailbox.shutdown();
            System.out.println(Thread.currentThread().getName() + " completed and requested shutdown.");
        } catch (InterruptedException ex) {
            // got woken because mailbox shutdown or interrupt; just exit
            Thread.currentThread().interrupt();
            // ensure shutdown requested so others are awake
            mailbox.shutdown();
            System.out.println(Thread.currentThread().getName() + " interrupted/exiting.");
        } catch (Exception ex) {
            // Any unexpected error should also trigger shutdown
            mailbox.shutdown();
            System.err.println(Thread.currentThread().getName() + " error: " + ex);
        }
    }
}
