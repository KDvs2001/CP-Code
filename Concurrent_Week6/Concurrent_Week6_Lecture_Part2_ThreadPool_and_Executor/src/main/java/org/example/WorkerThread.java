package org.example;

public class WorkerThread implements Runnable{
    private String name;
    public WorkerThread(String name){
        this.name = name;
    }
    @Override
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(this.name +" prints: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
