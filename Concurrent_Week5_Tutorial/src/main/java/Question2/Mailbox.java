package Question2;
public class Mailbox {
    private int item;
    private boolean available = false;
    public synchronized void put(int value){
        while(available){
            System.out.println(Thread.currentThread().getName() + " waiting: mailbox is FULL");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;
        item = value;
        System.out.println("Produced: "+ value);
        notifyAll();
    }

    public synchronized int get(){
        while(!available){
            System.out.println(Thread.currentThread().getName() + " waiting: mailbox is EMPTY");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        System.out.println("Consumed "+ item);
        notifyAll(); // Notifying the threads that are in the WAITING state
        return this.item;
    }
}
