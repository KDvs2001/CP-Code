package org.example.example;

public class Producer implements Runnable{
    private Mailbox mailbox;
    private int numOfProduction;
    private int processingTime;
    public Producer(Mailbox mailbox, int numOfProduction , int processingTime) {
        this.mailbox = mailbox;
        this.numOfProduction = numOfProduction;
        this.processingTime = processingTime;
    }

    @Override
    public void run(){
        for(int i=0;i<numOfProduction;i++){
            mailbox.put(i);
            System.out.println(Thread.currentThread().getName() + " puts the value: "+ i);
            try{
                Thread.sleep(processingTime);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
