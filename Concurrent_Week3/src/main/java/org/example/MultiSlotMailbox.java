package org.example;

import java.util.ArrayList;
import java.util.List;

public class MultiSlotMailbox<E> implements Mailbox<E> {
    private final List<E> mailslots;
    private final int capacity;
    private boolean stopped = false;

    public MultiSlotMailbox(int capacity) {
        this.mailslots = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public synchronized void put(E e) throws InterruptedException {
        // Wait while full unless we're stopped
        while (!stopped && mailslots.size() == capacity) {
            wait();
        }
        if (stopped) {
            // mailbox is shutting down — exit
            throw new InterruptedException("mailbox stopped");
        }
        mailslots.add(e);
        notifyAll(); // wake any waiting consumers
    }

    @Override
    public synchronized E get() throws InterruptedException {
        // Wait while empty unless we're stopped
        while (!stopped && mailslots.size() == 0) {
            wait();
        }
        if (stopped) {
            throw new InterruptedException("mailbox stopped");
        }
        E item = mailslots.remove(0);
        notifyAll(); // wake any waiting producers
        return item;
    }

    @Override
    public synchronized void shutdown() {
        if (!stopped) {
            stopped = true;
            notifyAll(); // wake all waiting threads so they can exit
        }
    }

    @Override
    public synchronized boolean isShutdown() {
        return stopped;
    }
}
