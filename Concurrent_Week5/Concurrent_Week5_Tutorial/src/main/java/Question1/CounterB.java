package Question1;

public class CounterB implements Runnable{
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
