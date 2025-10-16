package org.example;

public class Mother implements  Runnable{
    private Plate plate;

    public Mother(Plate plate){
        this.plate = plate;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            this.plate.putFood("Food " + i);
            System.out.println(Thread.currentThread().getName()+ " Serves Food " + i );
        }
    }
}
