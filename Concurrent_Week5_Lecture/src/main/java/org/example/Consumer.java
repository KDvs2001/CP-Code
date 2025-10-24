package org.example;

public class Consumer implements Runnable{
    private Mailbox mailbox;
    private int numOfConsumption;
    private int processingTime;
    public Consumer(Mailbox mailbox, int numOfConsumption , int processingTime) {
        this.mailbox = mailbox;
        this.numOfConsumption = numOfConsumption;
        this.processingTime = processingTime;
    }

    @Override
    public void run(){
        for(int i=0;i<numOfConsumption;i++){
            int value = mailbox.get();
            System.out.println(Thread.currentThread().getName() + " consumes: "+ value);
            try{
                Thread.sleep(processingTime);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
