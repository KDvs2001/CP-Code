package org.example;

public interface  Mailbox <E> {
    public void put(E e) throws InterruptedException;
    public E get() throws InterruptedException;
    void shutdown();       // request stop and wake waiters
    boolean isShutdown();

}
