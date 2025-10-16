package org.example;

public class Consumer<E> implements Runnable {
    private final Mailbox<E> mailbox;
    private final int itemsToConsume; // optional limit or you can loop forever until shutdown

    public Consumer(Mailbox<E> mailbox, int itemsToConsume) {
        this.mailbox = mailbox;
        this.itemsToConsume = itemsToConsume;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemsToConsume; i++) {
                if (mailbox.isShutdown()) break;
                E item = mailbox.get(); // may throw InterruptedException if shutdown
                System.out.println(Thread.currentThread().getName() + " consumes " + item);
            }
            // normal completion: request shutdown so everyone stops
            mailbox.shutdown();
            System.out.println(Thread.currentThread().getName() + " completed and requested shutdown.");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            mailbox.shutdown();
            System.out.println(Thread.currentThread().getName() + " interrupted/exiting.");
        } catch (Exception ex) {
            mailbox.shutdown();
            System.err.println(Thread.currentThread().getName() + " error: " + ex);
        }
    }
}
