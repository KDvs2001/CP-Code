package Question1;

public class CounterA extends Thread{ // This is not a good practice
    public CounterA(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            try {
                System.out.println(Thread.currentThread().getName() + " Count is: "+ i);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}